package com.eSports.BattleZone.services.user.impl;

import com.eSports.BattleZone.dto.UserDTO;
import com.eSports.BattleZone.entities.User;
import com.eSports.BattleZone.exceptions.ResourceNotFoundException;
import com.eSports.BattleZone.repositories.UserRepository;
import com.eSports.BattleZone.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUser() {
        log.info("Getting all users");
        List<User> userList = userRepository.findAll();
        return userList
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        log.info("Getting user by id : {}", id);

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : "+ id));
        return modelMapper.map(user, UserDTO.class);
    }
}
