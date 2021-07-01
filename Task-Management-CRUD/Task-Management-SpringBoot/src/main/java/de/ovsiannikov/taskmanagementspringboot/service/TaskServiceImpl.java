package de.ovsiannikov.taskmanagementspringboot.service;

import de.ovsiannikov.taskmanagementspringboot.entity.Task;
import de.ovsiannikov.taskmanagementspringboot.repository.TaskRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = Logger.getLogger(String.valueOf(TaskServiceImpl.class));

    private TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getSortedTasksList() {

        return repository.findAllByOrderByDueDateAsc().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Task create(String name, String description, LocalDateTime dueDate) {

        Task task = new Task(name, description,dueDate);
        return repository.save(task);
    }

    @Override
    public Task getById(int id) {

        Optional<Task> optionalTask = repository.findById(id);
        return optionalTask.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void edit(int id, @NotBlank String name, String description, LocalDateTime dueDate) {

        Task task = getById(id);
        task.setDescription(description);
        task.setDueDate(dueDate);

        if (dueDate.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("The date can't be in the past. Please provide a valid date.");
        }else{
            repository.save(task);
        }
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
