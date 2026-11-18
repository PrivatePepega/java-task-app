package com.example.demo.service.implementation;

import com.example.demo.domain.CreateTaskRequest;
import com.example.demo.domain.entity.Task;
import com.example.demo.domain.entity.TaskStatus;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class TaskServiceImplementation implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();

        Task task = new Task(
            null,
            request.title(),
            request.description(),
            request.dueDate(),
            TaskStatus.OPEN,
            request.priority(),
            now,
            now
        );

        return taskRepository.save(task);
    }
}
