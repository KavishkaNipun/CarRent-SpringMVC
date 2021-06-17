package lk.carrent.spring.controller;

import lk.carrent.spring.dto.DriverDTO;
import lk.carrent.spring.dto.UserDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.UserService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/carrent/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchUsers(String id){
        UserDTO usersDTO = userService.searchUsers(id);
        return new ResponseEntity(new StandardResponce("200", "Done", usersDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUsers(@RequestBody UserDTO userDTO){
        if (userDTO.getUserID().trim().length() <= 0) {
            throw new NotFoundException("User id cannot be empty");
        }
        userService.addUsers(userDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", userDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateUsers(@RequestBody UserDTO usersDTO){

        if (usersDTO.getUserID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        userService.updateUsers(usersDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", usersDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteUsers(String id){

        userService.deleteUsers(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUsers(@RequestBody DriverDTO driverDTO){
        ArrayList<UserDTO> allUsers= userService.getAllUsers();
        return new ResponseEntity(new StandardResponce("200", "Done", allUsers), HttpStatus.OK);
    }
}
