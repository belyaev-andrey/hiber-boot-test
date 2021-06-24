package com.example.hiberboottest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class HiberBootTestApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    void contextLoads() {
        final User byId = repository.findById(1).orElseThrow();
        byId.setFirstName("A22");
        repository.save(byId);
    }

}