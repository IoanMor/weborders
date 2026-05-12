package my.project.weborders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.project.weborders.util.RoleEnum;

import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_enum",nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleEnum, role.roleEnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleEnum);
    }
}
