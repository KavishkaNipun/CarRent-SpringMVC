package lk.carrent.spring.dto;

import lk.carrent.spring.entity.Driver;
import lk.carrent.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {
    private String scheduleID;
    private Rent rentID;
    private Driver driverID;
}
