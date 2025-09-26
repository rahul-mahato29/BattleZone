package com.eSports.BattleZone.services.admin.impl;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.entities.Admin;
import com.eSports.BattleZone.entities.enums.Role;
import com.eSports.BattleZone.exceptions.ResourceNotFoundException;
import com.eSports.BattleZone.repositories.AdminRepository;
import com.eSports.BattleZone.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<AdminDTO> getAllAdmin() {
        log.info("Getting All Admins");
        List<Admin> adminList = adminRepository.findAll();
        return adminList.stream().map( admin -> modelMapper.map(admin, AdminDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        log.info("Getting the admin with Id : {}", id);
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: "+ id));
        return modelMapper.map(admin, AdminDTO.class);
    }

    //todo: doubt - should I go for ID or EMAIL for finding an admin from the db  (email will be a better approach,
    //                                              but do we will be required to use id in-between for any logic)

    @Override
    public AdminDTO updateAdminPasswordById(Long id, String updatedPassword) {
        log.info("Updating the admins password with Id : {}", id);
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : "+ id));
        admin.setPassword(passwordEncoder.encode(updatedPassword));
        admin = adminRepository.save(admin);
        return modelMapper.map(admin, AdminDTO.class);
    }

    @Override
    public AdminDTO updateAdminRoleById(Long id, Role updatedRole) {
        log.info("Updating the admin role with Id : {}", id);
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : " +id));
        admin.setRole(updatedRole);
        admin = adminRepository.save(admin);
        return modelMapper.map(admin, AdminDTO.class);
    }

    @Override
    public String deleteAdminById(Long id) {
        log.info("Deleting the admin with Id : {}", id);
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : "+ id));
        if(admin != null) {
            adminRepository.deleteById(id);
            return "Admin Removed Successfully!!";
        }
        else {
            return "Admin Not Found!!";
        }
    }
}
