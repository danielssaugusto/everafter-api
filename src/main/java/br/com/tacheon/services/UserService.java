package br.com.tacheon.services;

import br.com.tacheon.DTOs.UserResponse;
import br.com.tacheon.entities.Invite;
import br.com.tacheon.entities.User;
import br.com.tacheon.entities.Wedding;
import br.com.tacheon.entities.WeddingParticipation;
import br.com.tacheon.repositories.InviteRepository;
import br.com.tacheon.repositories.UserRepository;
import br.com.tacheon.repositories.WeddingParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final InviteRepository inviteRepository;
    private final WeddingParticipationRepository weddingParticipationRepository;

    public UserService(
            UserRepository userRepository,
            InviteRepository inviteRepository,
            WeddingParticipationRepository weddingParticipationRepository) {
        this.userRepository = userRepository;
        this.inviteRepository = inviteRepository;
        this.weddingParticipationRepository = weddingParticipationRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password."));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password.");
        }

        return user;
    }

    private User findUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));
        return user;
    }

    public UserResponse displayUser(UUID id) {
        User user = findUser(id);

        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public User updateUsername(UUID id, String newUsername) {
        User user = findUser(id);

        user.setUsername(newUsername);

        return userRepository.save(user);
    }

    public User updatePassword(UUID id, String newPassword) {
        User user = findUser(id);

        user.setPassword(newPassword);

        return userRepository.save(user);
    }

    public User updateEmail(UUID id, String newEmail) {
        User user = findUser(id);

        user.setEmail(newEmail);

        return userRepository.save(user);
    }

    public User updatePhone(UUID id, String newPhone) {
        User user = findUser(id);

        user.setPhone(newPhone);

        return userRepository.save(user);
    }

    public void deleteUser(UUID id, String password) {
        User user = findUser(id);

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password.");
        }

        userRepository.delete(user);
    }

    public WeddingParticipation acceptInvite(UUID userId, UUID inviteId) {
        User user = findUser(userId);

        Invite invite = inviteRepository.findById(inviteId)
                .orElseThrow(() -> new RuntimeException("Invite not found."));

        Wedding wedding = invite.getWedding();

        if (weddingParticipationRepository.existsByUserAndWedding(user, wedding)) {
            throw new RuntimeException("User already participates in this wedding.");
        }

        WeddingParticipation weddingParticipation = new WeddingParticipation();

        weddingParticipation.setUser(user);
        weddingParticipation.setWedding(wedding);

        return weddingParticipationRepository.save(weddingParticipation);
    }
}
