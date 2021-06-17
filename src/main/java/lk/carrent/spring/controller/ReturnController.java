package lk.carrent.spring.controller;

import lk.carrent.spring.dto.DriverDTO;
import lk.carrent.spring.dto.ReturnDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.ReturnService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/carrent/return")
public class ReturnController {

    @Autowired
    private ReturnService returnService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchReturn(String id){
        ReturnDTO returnDTO = returnService.searchReturn(id);
        return new ResponseEntity(new StandardResponce("200", "Done", returnDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveReturns(@RequestBody ReturnDTO returnDTO){
        if (returnDTO.getReturnID().trim().length() <= 0) {
            throw new NotFoundException("Returns id cannot be empty");
        }
        returnService.addReturn(returnDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", returnDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateReturns(@RequestBody ReturnDTO returnsDTO){

        if (returnsDTO.getReturnID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        returnService.updateReturn(returnsDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", returnsDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteReturns(String id){

        returnService.deleteReturn(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllReturns(@RequestBody DriverDTO driverDTO){
        ArrayList<ReturnDTO> allReturn = returnService.getAllReturn();
        return new ResponseEntity(new StandardResponce("200", "Done", allReturn), HttpStatus.OK);
    }
}
