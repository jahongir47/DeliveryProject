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
@Table(name ="requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String  id;
    @NotNull(message = "This field is required")

    @ManyToOne
    private Place place;

    private String productId;

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
