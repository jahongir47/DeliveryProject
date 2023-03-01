package uz.jahongir.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "This field is required")
    @Size(min = 4,message = "FirstName should be at least 4 character long")
    private String firstName;

    @NotNull(message = "This field is required")
    @Size(min = 4,message = "LastName should be at least 4 character long")
    private String lastName;

    @NotNull(message = "This field is required")
    @Size(min = 4,message = "UserName should be at least 4 character long")
    private String userName;

    @NotNull(message = "This field is required")
    @Email(message = "You should be e-mail")
    private String email;

    @NotNull(message = "This field is required")
    @Size(min = 4,message = "Password should be at least 4 characters")
    private String password;

    private Boolean enabled=false;
    private String image;

}
