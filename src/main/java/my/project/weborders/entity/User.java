package my.project.weborders.entity;

import jakarta.persistence.*;
import lombok.*;
import my.project.weborders.util.RoleEnum;

import java.util.Objects;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_active")
    @Builder.Default private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username)
                && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }
}
