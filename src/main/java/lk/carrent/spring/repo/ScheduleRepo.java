package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,String> {
}
