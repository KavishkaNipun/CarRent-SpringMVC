package lk.carrent.spring.repo;

import lk.carrent.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
