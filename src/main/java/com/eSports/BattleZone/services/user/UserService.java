package com.eSports.BattleZone.services.user;

import com.eSports.BattleZone.dto.UserDTO;
import com.eSports.BattleZone.entities.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();

    UserDTO getUserById(Long id);

    String deleteUserById(Long id);
}
