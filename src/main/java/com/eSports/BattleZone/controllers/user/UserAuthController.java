package com.eSports.BattleZone.controllers.user;

import com.eSports.BattleZone.dto.*;
import com.eSports.BattleZone.services.admin.AdminAuthService;
import com.eSports.BattleZone.services.user.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDTO> singUp(@RequestBody UserSingUpDTO signUpDTO) {
        UserDTO user = userAuthService.signUp(signUpDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserDTO> logIn(@RequestBody LoginDTO loginDTO) {
        UserDTO user = userAuthService.logIn(loginDTO);
        return ResponseEntity.ok(user);
    }

}
