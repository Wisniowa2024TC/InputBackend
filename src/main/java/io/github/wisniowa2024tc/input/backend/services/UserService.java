package io.github.wisniowa2024tc.input.backend.services;

import io.github.wisniowa2024tc.input.backend.objects.LoginToken;
import io.github.wisniowa2024tc.input.backend.objects.User;
import io.github.wisniowa2024tc.input.backend.repositories.LoginTokenRepo;
import io.github.wisniowa2024tc.input.backend.repositories.UserRepo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired private UserRepo userRepo;
    @Autowired private LoginTokenRepo loginTokenRepo;

    public User createUser(User user) { return userRepo.save(user); }

    public Optional<LoginToken> login(UUID uuid) {
        Optional<User> user = userRepo.getUserByUuid(uuid);
        return user.map(value -> loginTokenRepo.save(new LoginToken(value)));
    }

    public void testSetup() {
        val user = userRepo.save(new User("uczen1", "qazwsx"));
    }
}
