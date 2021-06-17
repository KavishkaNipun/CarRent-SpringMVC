package lk.carrent.spring.service;

import lk.carrent.spring.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {
    void addPayment(PaymentDTO dto);

    void deletePayment(String id);

    PaymentDTO searchPayment(String id);

    ArrayList<PaymentDTO> getAllPayment();

    void updatePayment(PaymentDTO dto);
}
