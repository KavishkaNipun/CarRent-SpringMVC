package lk.carrent.spring.controller;

import lk.carrent.spring.dto.DriverDTO;
import lk.carrent.spring.dto.ReturnsDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.ReturnsService;
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
    private ReturnsService returnsService;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchReturn(String id){
        ReturnsDTO returnsDTO = returnsService.searchReturn(id);
        return new ResponseEntity(new StandardResponce("200", "Done", returnsDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveReturn(@RequestBody ReturnsDTO returnsDTO){
        if (returnsDTO.getReturnID().trim().length() <= 0) {
            throw new NotFoundException("Returns id cannot be empty");
        }
        returnsService.addReturn(returnsDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", returnsDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateReturn(@RequestBody ReturnsDTO returnsDTO){

        if (returnsDTO.getReturnID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        returnsService.updateReturn(returnsDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", returnsDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteReturn(String id){

        returnsService.deleteReturn(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllReturn(@RequestBody DriverDTO driverDTO){
        ArrayList<ReturnsDTO> allReturn = returnsService.getAllReturn();
        return new ResponseEntity(new StandardResponce("200", "Done", allReturn), HttpStatus.OK);
    }
}
