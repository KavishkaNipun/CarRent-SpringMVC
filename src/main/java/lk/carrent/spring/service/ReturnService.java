package lk.carrent.spring.service;

import lk.carrent.spring.dto.ReturnDTO;

import java.util.ArrayList;

public interface ReturnService {
    void addReturn(ReturnDTO dto);

    void deleteReturn(String id);

    ReturnDTO searchReturn(String id);

    ArrayList<ReturnDTO> getAllReturn();

    void updateReturn(ReturnDTO dto);
}
