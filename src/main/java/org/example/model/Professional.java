package org.example.model;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Role;

@Setter
@Getter
@DiscriminatorValue("PROFESSIONAL")
public class Professional {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String jobTitle;

    public Professional(Long id, String fullName, String email, String password, String jobTitle) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.jobTitle = jobTitle;
    }


    public Role getRole() {
        return Role.PROFESSIONAL;
    }

}
