package lk.carrent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Return {
    @Id
    private  String returnID;
    private  String returnFee;
    private  String reason;
}
