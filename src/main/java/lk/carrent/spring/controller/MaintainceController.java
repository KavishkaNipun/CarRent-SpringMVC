package lk.carrent.spring.controller;

import lk.carrent.spring.dto.MaintainceDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.MaintainceService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/carrent/maintaince")
public class MaintainceController {

    @Autowired
    private MaintainceService maintaineceService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchMaintainece(String id){
        MaintainceDTO maintaineceDTO = maintaineceService.searchMaintainece(id);
        return new ResponseEntity(new StandardResponce("200", "Done", maintaineceDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveMaintainece(@RequestBody MaintainceDTO maintaineceDTO){
        if (maintaineceDTO.getMaintainID().trim().length() <= 0) {
            throw new NotFoundException("Maintainece id cannot be empty");
        }
        maintaineceService.addMaintainece(maintaineceDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", maintaineceService), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateMaintainece(@RequestBody MaintainceDTO maintaineceDTO){

        if (maintaineceDTO.getMaintainID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        maintaineceService.updateMaintainece(maintaineceDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", maintaineceDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteMaintainece(String id){

        maintaineceService.deleteMaintainece(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllMaintainece(@RequestBody MaintainceDTO maintaineceDTO){
        ArrayList<MaintainceDTO> allMaintainece = maintaineceService.getAllMaintainece();
        return new ResponseEntity(new StandardResponce("200", "Done", allMaintainece), HttpStatus.OK);
    }
}
