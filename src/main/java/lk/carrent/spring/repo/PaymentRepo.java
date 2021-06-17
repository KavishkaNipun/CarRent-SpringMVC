package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {

}
