package lk.carrent.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    @Id
    private String customerID;
    private String firstName;
    private String lasTName;
    private String nicNumber;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;

    private List<RentDTO> rentOrder;
}
