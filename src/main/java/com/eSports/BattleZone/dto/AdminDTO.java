package com.eSports.BattleZone.dto;

import com.eSports.BattleZone.entities.enums.Role;
import lombok.Data;

@Data
public class AdminDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
