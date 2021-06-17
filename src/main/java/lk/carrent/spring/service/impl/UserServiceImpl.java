package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.UserDTO;
import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.User;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.UserRepo;
import lk.carrent.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo usersRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addUsers(UserDTO dto) {
        if (usersRepo.existsById(dto.getUserID())) {
            throw new ValidateException("User Already Exist");
        }
        usersRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public void deleteUsers(String id) {
        if (!usersRepo.existsById(id)) {
            throw new ValidateException("No User for Delete..!");
        }
        usersRepo.deleteById(id);

        usersRepo.deleteById(id);
    }

    @Override
    public UserDTO searchUsers(String id) {
        Optional<User> users = usersRepo.findById(id);
        if (users.isPresent()) {
            return mapper.map(users.get(), UserDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> users = usersRepo.findAll();
        return mapper.map(users,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateUsers(UserDTO dto) {
        if (usersRepo.existsById(dto.getUserID())) {
            usersRepo.save(mapper.map(dto, User.class));
        }
    }
}
