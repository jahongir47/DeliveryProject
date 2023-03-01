package uz.jahongir.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name ="places")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull(message = "This field is required")
    @Size(min = 3,message = "Place name should be at least 3 character long")
    private String name;

    @ManyToOne
    private Region region;

    @DateTimeFormat
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onCreate(){
        createdAt=new Date();
        updatedAt=new Date();
    }
    @PreUpdate
    public void onUpdate(){
        updatedAt=new Date();
    }

}
