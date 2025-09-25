package com.eSports.BattleZone.controllers.admin;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.entities.enums.Role;
import com.eSports.BattleZone.services.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admins")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminDTO>> getAllAdmin() {
        List<AdminDTO> adminList =  adminService.getAllAdmin();
        return ResponseEntity.ok(adminList);
    }

    @GetMapping(path = "/{adminId}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable(name = "adminId") Long id) {
        AdminDTO admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PatchMapping(path = "/{adminId}/update/password")
    public ResponseEntity<AdminDTO> updateAdminPasswordById(@PathVariable(name = "adminId") Long id, @RequestBody String updatedPassword) {
        AdminDTO admin = adminService.updateAdminPasswordById(id, updatedPassword);
        return ResponseEntity.ok(admin);
    }

    //todo : check the parameter "String" - getting issue

    @PatchMapping(path = "/{adminId}/update/role")
    public ResponseEntity<AdminDTO> updateAdminRoleById(@PathVariable(name = "adminId") Long id, @RequestBody Role updatedRole) {
        AdminDTO admin = adminService.updateAdminRoleById(id, updatedRole);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping(path = "/{adminId}")
    public ResponseEntity<String> deleteAdminById(@PathVariable(name = "adminId") Long id) {
        String message = adminService.deleteAdminById(id);
        return ResponseEntity.ok(message);
    }
}
