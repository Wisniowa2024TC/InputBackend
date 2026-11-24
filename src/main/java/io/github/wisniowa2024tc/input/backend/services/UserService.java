package io.github.wisniowa2024tc.input.backend.services;

import io.github.wisniowa2024tc.input.backend.objects.User;
import io.github.wisniowa2024tc.input.backend.repositories.UserRepo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserRepo userRepo;

    public User createUser(User user) { return userRepo.save(user); }

    public void testSetup() {
        val user = userRepo.save(new User("uczen1", "qazwsx"));
    }
}
