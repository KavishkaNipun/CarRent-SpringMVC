package lk.carrent.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity


public class Admin {
    @Id
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String nic;

    public Admin() {
    }

    public Admin(String adminID, String firstName, String lastName, String address, String contactNumber, String nic) {
        this.adminID = adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "admin{" +
                "adminID='" + adminID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
