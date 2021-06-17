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

@RestController
@RequestMapping("/carrent/payment")
public class PaymentController {

   @Autowired
    private PaymentService PaymentService;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchPayment(String id){
        PaymentDTO PaymentDTO = PaymentService.searchPayment(id);
        return new ResponseEntity(new StandardResponce("200", "Done", PaymentDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity savePayment(@RequestBody PaymentDTO PaymentDTO){
        if (PaymentDTO.getRentID().trim().length() <= 0) {
            throw new NotFoundException("Damage id cannot be empty");
        }
        PaymentService.addPayment(PaymentDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", PaymentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody PaymentDTO PaymentDTO){

        if (PaymentDTO.getRentID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        PaymentService.updatePayment(PaymentDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", PaymentDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeletePayment(String id){

        PaymentService.deletePayment(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllPayment(@RequestBody DriverDTO driverDTO){
        ArrayList<PaymentDTO> allRentPayment = PaymentService.getAllPayment();
        return new ResponseEntity(new StandardResponce("200", "Done", allRentPayment), HttpStatus.OK);
    }
}
