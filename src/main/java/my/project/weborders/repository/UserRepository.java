package my.project.weborders.repository;

import my.project.weborders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<User,Long> {

}
