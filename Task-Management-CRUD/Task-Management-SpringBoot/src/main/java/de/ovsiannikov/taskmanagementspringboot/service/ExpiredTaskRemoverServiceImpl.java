package de.ovsiannikov.taskmanagementspringboot.service;

import de.ovsiannikov.taskmanagementspringboot.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExpiredTaskRemoverServiceImpl implements ExpiredTaskRemoverService {

    private final TaskRepository taskRepository;

    public ExpiredTaskRemoverServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public Integer removeTaskWithExpiredDueDate() {

        return taskRepository.deleteTasksByDueDateBefore(LocalDateTime.now());
    }
}
