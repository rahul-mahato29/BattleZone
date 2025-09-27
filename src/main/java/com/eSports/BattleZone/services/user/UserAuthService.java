package com.eSports.BattleZone.services.user;

import com.eSports.BattleZone.dto.*;

public interface UserAuthService {
    UserDTO signUp(UserSingUpDTO signUpDTO);

    UserDTO logIn(LoginDTO loginDTO);
}
