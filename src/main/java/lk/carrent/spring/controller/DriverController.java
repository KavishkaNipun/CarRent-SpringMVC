package lk.carrent.spring.controller;

import lk.carrent.spring.dto.DriverDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.DriverService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/carrent/dirver")
public class DriverController {
    @Autowired
    private DriverService driverService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchDriver(String id){
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseEntity(new StandardResponce("200", "Done", driverDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveDamage(@RequestBody DriverDTO driverDTO){
        if (driverDTO.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("Damage id cannot be empty");
        }
        driverService.addDriver(driverDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", driverDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody DriverDTO driverDTO){

        if (driverDTO.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        driverService.updateDriver(driverDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", driverDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteDriver(String id){

        driverService.deleteDriver(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver(@RequestBody DriverDTO driverDTO){
        ArrayList<DriverDTO> allDamage = driverService.getAllDriver();
        return new ResponseEntity(new StandardResponce("200", "Done", allDamage), HttpStatus.OK);
    }
}
