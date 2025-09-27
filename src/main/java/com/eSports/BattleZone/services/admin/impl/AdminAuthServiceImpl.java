package com.eSports.BattleZone.services.admin.impl;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.dto.LoginDTO;
import com.eSports.BattleZone.dto.AdminSignUpDTO;
import com.eSports.BattleZone.entities.Admin;
import com.eSports.BattleZone.repositories.AdminRepository;
import com.eSports.BattleZone.services.admin.AdminAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminAuthServiceImpl implements AdminAuthService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AdminDTO signUp(AdminSignUpDTO signUpDTO) {
        Optional<Admin> admin = adminRepository.findByEmail(signUpDTO.getEmail());
        if(admin.isPresent()) {
            System.out.println("Not present");
        }

        Admin toBeCreatedAdmin = modelMapper.map(signUpDTO, Admin.class);
        toBeCreatedAdmin.setPassword(passwordEncoder.encode(toBeCreatedAdmin.getPassword()));
        Admin savedAdmin = adminRepository.save(toBeCreatedAdmin);

        return modelMapper.map(savedAdmin, AdminDTO.class);
    }

    @Override
    public AdminDTO logIn(LoginDTO loginDTO) {
        //todo
        return null;
    }
}
