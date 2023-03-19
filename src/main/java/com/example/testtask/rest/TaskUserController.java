package com.example.testtask.rest;

import com.example.testtask.domain.TaskUserDTO;
import com.example.testtask.service.TaskUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskUserController {

    private final TaskUserService taskUserService;

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(taskUserService.getUser(id));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body("User not found");
        }

    }
}
