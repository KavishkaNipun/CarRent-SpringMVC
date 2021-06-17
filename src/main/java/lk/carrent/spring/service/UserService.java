package lk.carrent.spring.service;

import lk.carrent.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    void addUsers(UserDTO dto);

    void deleteUsers(String id);

    UserDTO searchUsers(String id);

    ArrayList<UserDTO> getAllUsers();

    void updateUsers(UserDTO dto);
}
