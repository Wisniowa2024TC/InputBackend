package io.github.wisniowa2024tc.input.backend;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TestUser, Integer> {
    TestUser findByName(String name);
}
