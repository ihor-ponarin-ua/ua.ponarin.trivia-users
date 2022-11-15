package ua.ponarin.triviausers.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    @Pattern(regexp = "[\\p{Alnum}-_]+", message = "Only alphanumeric, '-', '_' symbols are allowed")
    private String login;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false)
    @NotBlank
    private String role;

    @Column(name = "first_name", nullable = false)
    @Pattern(regexp = "\\p{Alpha}+", message = "Only alphabetic symbols are allowed")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Pattern(regexp = "\\p{Alpha}+", message = "Only alphabetic symbols are allowed")
    private String lastName;

    @Column(name = "created_on")
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;
}
