package lk.carrent.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnsDTO {

    private  String returnID;
    private  String returnFee;
    private  String reason;
}
