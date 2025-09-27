package com.eSports.BattleZone.dto;

import com.eSports.BattleZone.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSignUpDTO {
    private String name;
    private String email;
    private String password;
    private Role role;
}
