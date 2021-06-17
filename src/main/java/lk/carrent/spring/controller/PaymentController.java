package lk.carrent.spring.controller;

import lk.carrent.spring.dto.DriverDTO;
import lk.carrent.spring.dto.PaymentDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.PaymentService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class PaymentController {
    @Autowired
    private PaymentService PaymentService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchPayment(String id){
        PaymentDTO PaymentDTO = PaymentService.searchRentPayment(id);
        return new ResponseEntity(new StandardResponce("200", "Done", PaymentDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveRentPayment(@RequestBody PaymentDTO rentPaymentDTO){
        if (rentPaymentDTO.getRentID().trim().length() <= 0) {
            throw new NotFoundException("Damage id cannot be empty");
        }
        PaymentService.addPayment(PaymentDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", rentPaymentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody PaymentDTO rentPaymentDTO){

        if (rentPaymentDTO.getRentID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        PaymentService.updateRentPayment(rentPaymentDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", rentPaymentDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteRentpayment(String id){

        PaymentService.deleteRentPayment(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllRentPayment(@RequestBody DriverDTO driverDTO){
        ArrayList<PaymentDTO> allRentPayment = PaymentService.getAllRentPayment();
        return new ResponseEntity(new StandardResponce("200", "Done", allRentPayment), HttpStatus.OK);
    }
}
