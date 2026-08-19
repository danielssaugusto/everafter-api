package br.com.tacheon.services;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String to, String message) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject("You received a invite.");
        email.setText(message);

        mailSender.send(email);
    }
}
