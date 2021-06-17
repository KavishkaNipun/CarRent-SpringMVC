package lk.carrent.spring.service;

import lk.carrent.spring.dto.ReturnsDTO;

import java.util.ArrayList;

public interface ReturnsService {
    void addReturn(ReturnsDTO dto);

    void deleteReturn(String id);

    ReturnsDTO searchReturn(String id);

    ArrayList<ReturnsDTO> getAllReturn();

    void updateReturn(ReturnsDTO dto);
}
