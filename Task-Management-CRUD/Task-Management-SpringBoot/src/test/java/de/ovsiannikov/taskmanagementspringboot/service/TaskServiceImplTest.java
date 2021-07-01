package de.ovsiannikov.taskmanagementspringboot.service;

import de.ovsiannikov.taskmanagementspringboot.entity.Task;
import de.ovsiannikov.taskmanagementspringboot.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import static de.ovsiannikov.taskmanagementspringboot.prototype.TaskPrototype.*;
import static de.ovsiannikov.taskmanagementspringboot.prototype.TasksListPrototype.emptyList;
import static de.ovsiannikov.taskmanagementspringboot.prototype.TasksListPrototype.sortedListByDueDateWith4Tasks;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceImplTest {

    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskServiceImpl(taskRepository);
    }

    @Test
    void getSortedTasksList_with_existingList() {
        when(taskRepository.findAllByOrderByDueDateAsc()).thenReturn(Optional.of(sortedListByDueDateWith4Tasks()));

        List<Task> actualSortedTasksList = taskService.getSortedTasksList();

        verify(taskRepository, times(1)).findAllByOrderByDueDateAsc();
        assertThat(actualSortedTasksList).isNotNull();
        assertEquals(4, actualSortedTasksList.size());
        assertEquals(sortedListByDueDateWith4Tasks(),actualSortedTasksList);
    }

    @Test
    void getSortedTasksList_with_emptyList() {
        when(taskRepository.findAllByOrderByDueDateAsc()).thenReturn(Optional.of(emptyList()));

        List<Task> actualSortedTasksList = taskService.getSortedTasksList();

        verify(taskRepository, times(1)).findAllByOrderByDueDateAsc();
        assertThat(actualSortedTasksList).isNotNull();
        assertEquals(emptyList(),actualSortedTasksList);
    }

    @Test
    void create() {
        when(taskRepository.save(any())).thenReturn(taskFromDB());
        Task createdTask = taskService.create(
                taskFromUser().getName(),
                taskFromUser().getDescription(),
                taskFromUser().getDueDate());

        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getName()).isEqualTo(taskFromDB().getName());
        verify(taskRepository, times(1)).save(any());
    }


    @Test
    void getById() {
        when(taskRepository.findById(1)).thenReturn(Optional.of(taskFromDB()));

        Task foundTask = taskService.getById(1);
        assertThat(foundTask).isNotNull();

        verify(taskRepository, times(1)).findById(argThat(
                id -> id == 1));
    }


    @Test
    void getById_wrongTaskId() {

        assertThrows(EntityNotFoundException.class, () -> taskService.getById(taskFromDB().getId()));
        verify(taskRepository, times(1)).findById(any());

    }

    @Test
    void delete() {
        taskService.delete(taskFromDB().getId());
        verify(taskRepository, times(1)).deleteById(taskFromDB().getId());
    }
}
