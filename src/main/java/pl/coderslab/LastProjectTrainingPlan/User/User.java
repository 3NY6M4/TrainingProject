package pl.coderslab.LastProjectTrainingPlan.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String login;
    @Size (min= 1, max=255)
    private String email;
    @Size (min= 1, max=255)
    private String password;
    private Timestamp createdAccount = Timestamp.valueOf(LocalDateTime.now());
    private boolean isAdmin;


}