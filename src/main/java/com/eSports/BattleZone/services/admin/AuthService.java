package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.dto.LoginDTO;
import com.eSports.BattleZone.dto.SignUpDTO;

public interface AuthService {
    AdminDTO signUp(SignUpDTO signUpDTO);

    AdminDTO logIn(LoginDTO loginDTO);
}
