package de.ovsiannikov.taskmanagementspringboot.controller;

import de.ovsiannikov.taskmanagementspringboot.dto.TaskDto;
import de.ovsiannikov.taskmanagementspringboot.entity.Task;
import de.ovsiannikov.taskmanagementspringboot.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity <TaskDto> create(@Valid @RequestBody TaskDto taskDto) {

        Task task = taskService.create(
                taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getDueDate());
        taskDto.id = task.getId();

        return new ResponseEntity<>(taskDto, HttpStatus.CREATED) ;

    }

    @GetMapping
    public List<TaskDto> getAll () {
        return taskService.getSortedTasksList()
                .stream()
                .map(task -> new TaskDto(
                        task.getId(),
                        task.getName(),
                        task.getDescription(),
                        task.getDueDate()))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public TaskDto getById (@PathVariable int id) {
        Task task = taskService.getById(id);

        return new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDueDate());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edit (@RequestBody TaskDto taskDto) {
        taskService.edit(
                taskDto.id,
                taskDto.name,
                taskDto.description,
                taskDto.dueDate);
    }

    @DeleteMapping("{id}")
    public void deleteById (@PathVariable int id) {
        taskService.delete(id);
    }
}
