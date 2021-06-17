package lk.carrent.spring.controller;

import lk.carrent.spring.dto.DriverDTO;
import lk.carrent.spring.dto.ScheduleDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.ScheduleService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/carrent/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchSchedule(String id){
        ScheduleDTO scheduleDTO = scheduleService.searchSchedule(id);
        return new ResponseEntity(new StandardResponce("200", "Done", scheduleDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveSchedule(@RequestBody ScheduleDTO scheduleDTO){
        if (scheduleDTO.getScheduleID().trim().length() <= 0) {
            throw new NotFoundException("Returns id cannot be empty");
        }
        scheduleService.addSchedule(scheduleDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", scheduleDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateSchedule(@RequestBody ScheduleDTO scheduleDTO){

        if (scheduleDTO.getScheduleID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        scheduleService.updateSchedule(scheduleDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", scheduleDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteSchedule(String id){

        scheduleService.deleteSchedule(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllSchedule(@RequestBody DriverDTO driverDTO){
        ArrayList<ScheduleDTO> allSchedule = scheduleService.getAllSchedule();
        return new ResponseEntity(new StandardResponce("200", "Done", allSchedule), HttpStatus.OK);
    }
}
