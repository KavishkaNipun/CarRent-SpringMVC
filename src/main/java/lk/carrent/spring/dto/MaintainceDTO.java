package lk.carrent.spring.dto;

import lk.carrent.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaintainceDTO {
    private String maintainID;
    private String status;
    private String reason;
    private String date;
    private Vehicle vehicle;
}
