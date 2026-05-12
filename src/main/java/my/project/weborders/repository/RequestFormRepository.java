package my.project.weborders.repository;

import my.project.weborders.entity.RequestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestFormRepository extends JpaRepository<RequestForm, Long> {
}
