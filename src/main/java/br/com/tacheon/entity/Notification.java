package br.com.tacheon.entity;

import br.com.tacheon.enums.NotificationType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Notification {
    private UUID notificationId;
    private User user;
    private NotificationType notificationType;
    private String notificationTitle;
    private String message;
    private boolean read;
    private LocalDateTime initDate;
    private LocalDateTime readDate;

    public Notification(User user, NotificationType notificationType, String notificationTitle, String message, boolean read, LocalDateTime initDate, LocalDateTime readDate) {
        this.user = user;
        this.notificationType = notificationType;
        this.notificationTitle = notificationTitle;
        this.message = message;
        this.read = read;
        this.initDate = initDate;
        this.readDate = readDate;
    }
}