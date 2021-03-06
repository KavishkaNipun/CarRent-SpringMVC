package lk.carrent.spring.service;

import lk.carrent.spring.dto.RentDTO;

import java.util.ArrayList;

public interface RentService {
    void addRent(RentDTO dto);

    void deleteRent(String id);

    RentDTO searchRent(String id);

    ArrayList<RentDTO> getAllRent();

    void updateRent(RentDTO dto);
}
