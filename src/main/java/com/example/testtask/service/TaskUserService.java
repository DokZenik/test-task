package com.example.testtask.service;

import com.example.testtask.domain.TaskUser;
import com.example.testtask.domain.TaskUserDTO;
import com.example.testtask.repository.TaskUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskUserService {

    private final TaskUserRepository taskUserRepository;

    public TaskUserDTO getUser(Long id) {
        TaskUser user = taskUserRepository.findById(id).orElseThrow(() -> new RuntimeException("Value is empty"));
        return new TaskUserDTO(
                user.getFirstName(),
                user.getLastName(),
                LocalDateTime.now().minusYears(user.getDateOfBirth().getYear()).minusMonths(user.getDateOfBirth().getMonth().getValue()).getYear()
        );
    }
}
