package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.MaintainceDTO;
import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.Maintaince;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.MaintainceRepo;
import lk.carrent.spring.service.MaintainceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaintainceServiceImpl implements MaintainceService {

    @Autowired
    private MaintainceRepo maintainceRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addMaintainece(MaintainceDTO dto) {
        if(maintainceRepo.existsById(dto.getMaintainID())){
            throw new ValidateException("Maintaince Already Exist");
        }
        maintainceRepo.save(mapper.map(dto, Maintaince.class));

    }

    @Override
    public void deleteMaintainece(String id) {
        if (!maintainceRepo.existsById(id)) {
            throw new ValidateException("No Maintainece for Delete..!");
        }
        maintainceRepo.deleteById(id);

        maintainceRepo.deleteById(id);
    }

    @Override
    public MaintainceDTO searchMaintainece(String id) {
        Optional<Maintaince> maintainece = maintainceRepo.findById(id);
        if (maintainece.isPresent()) {
            return mapper.map(maintainece.get(), MaintainceDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<MaintainceDTO> getAllMaintainece() {
        List<Maintaince> maintaineces = maintainceRepo.findAll();
        return mapper.map(maintaineces,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateMaintainece(MaintainceDTO dto) {
        if (maintainceRepo.existsById(dto.getMaintainID())) {
            maintainceRepo.save(mapper.map(dto, Maintaince.class));
        }
    }
}
