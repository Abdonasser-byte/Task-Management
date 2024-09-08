package com.taskmanagement.testing.JpaTests;

import com.taskmanagement.model.UserEntity;
import com.taskmanagement.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    final private UserRepository userRepository;

     UserRepositoryTest(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Test
    void testFindByUsername() {
        UserEntity user = new UserEntity(null, "username", "password", "email@example.com", null, null);
        userRepository.save(user);

        Optional<UserEntity> foundUser = userRepository.findByUsername("username");

       // assertEquals("username", );
    }

    @Test
    void testExistsByUsername() {
        UserEntity user = new UserEntity(null, "username", "password", "email@example.com", null, null);
        userRepository.save(user);

        boolean exists = userRepository.existsByUsername("username");
        assertTrue(exists);
    }
}