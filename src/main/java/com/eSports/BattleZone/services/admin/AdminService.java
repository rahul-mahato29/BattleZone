package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.AdminDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<AdminDTO> getAllAdmin();

    AdminDTO getAdminById(Long id);

    AdminDTO updateAdminPasswordById(Long id, String updatedPassword);
}
