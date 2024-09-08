package com.taskmanagement.testing.JpaTests;

import com.taskmanagement.model.TaskEntity;
import com.taskmanagement.model.UserEntity;
import com.taskmanagement.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testFindByUserId() {
        UserEntity user = new UserEntity(null, "username", "password", "email@example.com", null, null);
        TaskEntity task1 = new TaskEntity(null, "Task 1", "Description 1", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null, user);
        TaskEntity task2 = new TaskEntity(null, "Task 2", "Description 2", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null, user);
        taskRepository.save(task1);
        taskRepository.save(task2);

        List<TaskEntity> tasks = taskRepository.findByUserId(user.getId());
        assertEquals(2, tasks.size());
    }
}
