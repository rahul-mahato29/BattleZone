package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.dto.LoginDTO;
import com.eSports.BattleZone.dto.AdminSignUpDTO;
import com.eSports.BattleZone.dto.UserSingUpDTO;

public interface AdminAuthService {
    AdminDTO signUp(AdminSignUpDTO signUpDTO);

    AdminDTO logIn(LoginDTO loginDTO);
}
