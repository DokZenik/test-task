package com.example.testtask.service;

import com.example.testtask.domain.TaskUser;
import com.example.testtask.domain.TaskUserDTO;
import com.example.testtask.repository.TaskUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskUserService {

    private final TaskUserRepository taskUserRepository;

    @Transactional
    public TaskUserDTO getUser(Long id) {
        TaskUser user = taskUserRepository.findById(id).orElseThrow(() -> new RuntimeException("Value is empty"));
        int age = LocalDateTime.now().getYear() - user.getDateOfBirth().getYear();
        if (
                (user.getDateOfBirth().getMonth().getValue() > LocalDateTime.now().getMonth().getValue())
                        ||
                        (user.getDateOfBirth().getMonth().getValue() == LocalDateTime.now().getMonth().getValue()
                                && user.getDateOfBirth().getDayOfMonth() > LocalDateTime.now().getDayOfMonth())
        )
            age--;

        return new TaskUserDTO(
                user.getFirstName(),
                user.getLastName(),
                age
        );
    }
}
