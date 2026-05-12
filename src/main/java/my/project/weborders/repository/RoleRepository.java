package my.project.weborders.repository;

import my.project.weborders.entity.Role;
import my.project.weborders.util.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleEnum(RoleEnum roleEnum);
}
