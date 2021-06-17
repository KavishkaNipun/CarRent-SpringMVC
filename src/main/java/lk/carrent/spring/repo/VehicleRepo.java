package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
