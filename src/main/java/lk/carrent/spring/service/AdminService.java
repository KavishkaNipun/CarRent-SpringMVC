package lk.carrent.spring.service;

import lk.carrent.spring.dto.AdminDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface AdminService {
    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    AdminDTO searchAdmin(String id);

    ArrayList<AdminDTO> getAllAdmins();

    void updateAdmin(AdminDTO dto);
}
