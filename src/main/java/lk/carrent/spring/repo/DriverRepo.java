package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {

}
