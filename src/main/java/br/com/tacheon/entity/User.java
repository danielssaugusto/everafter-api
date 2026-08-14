package br.com.tacheon.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private Date initData;
    private Date updateData;
    private boolean active = true;

    public User(String username, String email, String password, String phone, Date initData, Date updateData, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.initData = initData;
        this.updateData = updateData;
        this.active = active;
    }
}
