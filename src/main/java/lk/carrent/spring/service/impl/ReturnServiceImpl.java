package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.ReturnDTO;
import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.Return;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.ReturnRepo;
import lk.carrent.spring.service.ReturnService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnRepo returnRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addReturn(ReturnDTO dto) {
        if (returnRepo.existsById(dto.getReturnID())) {
            throw new ValidateException("Return Already Exist");
        }
        returnRepo.save(mapper.map(dto, Return.class));
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
    public ReturnDTO searchReturn(String id) {
        Optional<Return> returns = returnRepo.findById(id);
        if (returns.isPresent()) {
            return mapper.map(returns.get(), ReturnDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ReturnDTO> getAllReturn() {
        List<Return> returns = returnRepo.findAll();
        return mapper.map(returns,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateReturn(ReturnDTO dto) {
        if (returnRepo.existsById(dto.getReturnID())) {
            returnRepo.save(mapper.map(dto, Return.class));
        }
    }
}
