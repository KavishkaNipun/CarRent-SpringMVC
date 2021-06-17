package lk.carrent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {
    @Id
    private String rentID;
    private String date;
    private double fee;
    private String method;
}
