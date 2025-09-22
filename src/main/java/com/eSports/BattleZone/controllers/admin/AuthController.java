package com.eSports.BattleZone.controllers.admin;

import com.eSports.BattleZone.dto.AdminDTO;
import com.eSports.BattleZone.dto.SignUpDTO;
import com.eSports.BattleZone.services.admin.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<AdminDTO> singUp(@RequestBody SignUpDTO signUpDTO) {
        AdminDTO admin = authService.signUp(signUpDTO);
        return ResponseEntity.ok(admin);
    }


}
