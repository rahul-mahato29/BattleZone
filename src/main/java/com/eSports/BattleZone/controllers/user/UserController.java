package com.eSports.BattleZone.controllers.user;

import com.eSports.BattleZone.dto.UserDTO;
import com.eSports.BattleZone.entities.User;
import com.eSports.BattleZone.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "userId") Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable(name = "userId") Long id) {
        String message = userService.deleteUserById(id);
        return ResponseEntity.ok(message);
    }
}
