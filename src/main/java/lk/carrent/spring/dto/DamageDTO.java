package lk.carrent.spring.dto;

import lk.carrent.spring.entity.Return;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DamageDTO {
    private String damageID;
    private double returnFee;
    private String reason;
    private Return Return;
}
