package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Maintaince;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintainceRepo extends JpaRepository<Maintaince,String> {
}
