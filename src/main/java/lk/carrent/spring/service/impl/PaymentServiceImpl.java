package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.PaymentDTO;
import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.Payment;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.PaymentRepo;
import lk.carrent.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo PaymentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addPayment(PaymentDTO dto) {
        if (PaymentRepo.existsById(dto.getRentID())) {
            throw new ValidateException("Customer Already Exist");
        }
        PaymentRepo.save(mapper.map(dto, Payment.class));
    }

    @Override
    public void deletePayment(String id) {
        if (!PaymentRepo.existsById(id)) {
            throw new ValidateException("No Rent for Delete..!");
        }
        PaymentRepo.deleteById(id);

        PaymentRepo.deleteById(id);
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        Optional<Payment> Payment = PaymentRepo.findById(id);
        if (Payment.isPresent()) {
            return mapper.map(Payment.get(), PaymentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayment() {
        List<Payment> rentPayments = PaymentRepo.findAll();
        return mapper.map(rentPayments,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (PaymentRepo.existsById(dto.getRentID())) {
            PaymentRepo.save(mapper.map(dto, Payment.class));
        }
    }
}
