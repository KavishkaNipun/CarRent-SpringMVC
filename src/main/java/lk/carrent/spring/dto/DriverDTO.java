package lk.carrent.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {
    private String driverId;
    private String firstName;
    private String lastName;
    private String address;
    private String contatNumber;
    private String nic;
    private List<RentDTO> rentOrder;
}
