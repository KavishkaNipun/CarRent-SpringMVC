package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepo extends JpaRepository<Damage, String> {
}
