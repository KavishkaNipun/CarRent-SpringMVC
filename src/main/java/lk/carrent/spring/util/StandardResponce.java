package lk.carrent.spring.util;

import lk.carrent.spring.dto.AdminDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponce {
    private String code;
    private String massage;
    private Object data;

}
