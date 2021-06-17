package lk.carrent.spring.service;

import lk.carrent.spring.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {
    void addRentPayment(PaymentDTO dto);

    void deleteRentPayment(String id);

    PaymentDTO searchRentPayment(String id);

    ArrayList<PaymentDTO> getAllRentPayment();

    void updateRentPayment(PaymentDTO dto);
}
