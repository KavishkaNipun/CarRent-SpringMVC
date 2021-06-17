package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.ReturnsDTO;
import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.Returns;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.ReturnRepo;
import lk.carrent.spring.service.ReturnsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReturnsServiceImpl implements ReturnsService {
    @Autowired
    private ReturnRepo returnRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addReturn(ReturnsDTO dto) {
        if (returnRepo.existsById(dto.getReturnID())) {
            throw new ValidateException("Return Already Exist");
        }
        returnRepo.save(mapper.map(dto, Returns.class));
    }

    @Override
    public void deleteReturn(String id) {
        if (!returnRepo.existsById(id)) {
            throw new ValidateException("No Return for Delete..!");
        }
        returnRepo.deleteById(id);

        returnRepo.deleteById(id);
    }

    @Override
    public ReturnsDTO searchReturn(String id) {
        Optional<Returns> returns = returnRepo.findById(id);
        if (returns.isPresent()) {
            return mapper.map(returns.get(), ReturnsDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ReturnsDTO> getAllReturn() {
        List<Returns> returns = returnRepo.findAll();
        return mapper.map(returns,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateReturn(ReturnsDTO dto) {
        if (returnRepo.existsById(dto.getReturnID())) {
            returnRepo.save(mapper.map(dto, Returns.class));
        }
    }
}
