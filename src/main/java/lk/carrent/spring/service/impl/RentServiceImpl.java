package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.RentDTO;
import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.Rent;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.RentRepo;
import lk.carrent.spring.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepo rentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRent(RentDTO dto) {
        if (rentRepo.existsById(dto.getRentID())) {
            throw new ValidateException("Rent Already Exist");
        }
        rentRepo.save(mapper.map(dto, Rent.class));
    }

    @Override
    public void deleteRent(String id) {
        if (!rentRepo.existsById(id)) {
            throw new ValidateException("No Rent for Delete..!");
        }
        rentRepo.deleteById(id);

        rentRepo.deleteById(id);
    }

    @Override
    public RentDTO searchRent(String id) {
        Optional<Rent> rent = rentRepo.findById(id);
        if (rent.isPresent()) {
            return mapper.map(rent.get(), RentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentDTO> getAllRent() {
        List<Rent> rent = rentRepo.findAll();
        return mapper.map(rent,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateRent(RentDTO dto) {
        if (rentRepo.existsById(dto.getRentID())) {
            rentRepo.save(mapper.map(dto, Rent.class));
        }
    }
}
