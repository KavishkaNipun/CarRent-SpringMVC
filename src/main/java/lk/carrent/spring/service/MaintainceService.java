package lk.carrent.spring.service;

import lk.carrent.spring.dto.MaintainceDTO;

import java.util.ArrayList;

public interface MaintainceService {
    void addMaintainece(MaintainceDTO dto);

    void deleteMaintainece(String id);

    MaintainceDTO searchMaintainece(String id);

    ArrayList<MaintainceDTO> getAllMaintainece();

    void updateMaintainece(MaintainceDTO dto);
}
