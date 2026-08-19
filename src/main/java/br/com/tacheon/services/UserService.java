package br.com.tacheon.services;

import br.com.tacheon.DTOs.UserRequestDTO;
import br.com.tacheon.DTOs.UserResponseDTO;
import br.com.tacheon.entities.User;
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

    public UserResponseDTO createUser(UserRequestDTO request) {
        User user = new User();

        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setPassword(request.password());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getPhone()
        );
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

    public UserResponseDTO displayUser(UUID id) {
        User user = findUser(id);

        return new UserResponseDTO(
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
}
