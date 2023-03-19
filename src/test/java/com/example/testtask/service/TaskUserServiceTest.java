package com.example.testtask.service;

import com.example.testtask.domain.TaskUser;
import com.example.testtask.domain.TaskUserDTO;
import com.example.testtask.repository.TaskUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskUserServiceTest {

    @Autowired
    private TaskUserService taskUserService;

    @MockBean
    private TaskUserRepository taskUserRepository;

    @Test
    void getUserWithoutException() {
        //---------- First counting test ----------

        Mockito.when(taskUserRepository.findById(1L)).thenReturn(Optional.of(new TaskUser(1L, "TestFN", "TestLN", LocalDateTime.now().minusYears(1).plusDays(1))));
        TaskUserDTO user = taskUserService.getUser(1L);
        Assert.isTrue(user.getAge() == 0, "Wrong calculating of age. Returning age is = " + user.getAge());

        //---------- Second counting test ----------

        Mockito.when(taskUserRepository.findById(1L)).thenReturn(Optional.of(new TaskUser(1L, "TestFN", "TestLN", LocalDateTime.now().minusYears(1).minusDays(1))));
        user = taskUserService.getUser(1L);
        Assert.isTrue(user.getAge() == 1, "Wrong calculating of age. Returning age is = " + user.getAge());

    }

    @Test
    void getUserWithException(){
        Assertions.assertThrows(RuntimeException.class,() -> taskUserService.getUser(1L));
    }
}