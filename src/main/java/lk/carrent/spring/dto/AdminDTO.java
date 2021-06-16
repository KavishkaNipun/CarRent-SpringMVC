package lk.carrent.spring.dto;

import javax.persistence.Id;

public class AdminDTO {

    @Id
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String nic;
}
