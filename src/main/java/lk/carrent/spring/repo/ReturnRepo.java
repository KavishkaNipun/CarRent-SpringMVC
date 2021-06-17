package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Returns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepo extends JpaRepository<Returns,String> {
}
