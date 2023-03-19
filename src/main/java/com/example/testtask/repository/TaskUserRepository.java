package com.example.testtask.repository;

import com.example.testtask.domain.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskUserRepository extends JpaRepository<TaskUser, Long> {
}
