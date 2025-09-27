package com.eSports.BattleZone.services.user.impl;

import com.eSports.BattleZone.dto.*;
import com.eSports.BattleZone.entities.Admin;
import com.eSports.BattleZone.entities.User;
import com.eSports.BattleZone.repositories.UserRepository;
import com.eSports.BattleZone.services.admin.AdminAuthService;
import com.eSports.BattleZone.services.user.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO signUp(UserSingUpDTO signUpDTO) {
        Optional<User> admin = userRepository.findByEmail(signUpDTO.getEmail());
        if(admin.isPresent()) {
            System.out.println("Not present");
        }

        User toBeCreatedUser = modelMapper.map(signUpDTO, User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
        User savedUser = userRepository.save(toBeCreatedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO logIn(LoginDTO loginDTO) {
        //todo
        return null;
    }
}
