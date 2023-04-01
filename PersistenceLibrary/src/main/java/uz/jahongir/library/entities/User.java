package uz.jahongir.library.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Username required")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password required")
    private String password;

    @NotBlank(message = "firstName required")
    private String firstName;

    @NotBlank(message = "lastName required")
    private String lastName;

    @NotBlank(message = "phone required")
    private String phone;

    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    private Date createdAt;
    private Date updatedAt;



    @PrePersist
    public void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
        active = true;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Date();
    }


}
