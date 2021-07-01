package de.ovsiannikov.taskmanagementspringboot.service;

import de.ovsiannikov.taskmanagementspringboot.entity.Task;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {

    List<Task> getSortedTasksList();
    Task create (String name, String description, LocalDateTime dueDate);
    Task getById(int id);
    void edit(int id, @NotBlank String name, String description, LocalDateTime dueDate);
    void delete(int id);
}
