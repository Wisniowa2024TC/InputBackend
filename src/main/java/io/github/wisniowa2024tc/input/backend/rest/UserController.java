package io.github.wisniowa2024tc.input.backend.rest;

import io.github.wisniowa2024tc.input.backend.objects.LoginToken;
import io.github.wisniowa2024tc.input.backend.objects.User;
import io.github.wisniowa2024tc.input.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired private UserService userService;

    @PostMapping(path = "createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping(path = "login")
    public ResponseEntity<UUID> login(@RequestBody UUID uuid) {
        Optional<LoginToken> token = userService.login(uuid);
        return token.map(loginToken -> ResponseEntity.ok(loginToken.getUuid())).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
