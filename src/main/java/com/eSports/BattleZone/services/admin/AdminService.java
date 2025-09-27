package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.entities.enums.Role;

import java.util.List;

public interface AdminService {
    List<AdminDTO> getAllAdmin();

    AdminDTO getAdminById(Long id);

    AdminDTO updateAdminPasswordById(Long id, String updatedPassword);

    AdminDTO updateAdminRoleById(Long id, Role updatedRole);

    String deleteAdminById(Long id);
}
