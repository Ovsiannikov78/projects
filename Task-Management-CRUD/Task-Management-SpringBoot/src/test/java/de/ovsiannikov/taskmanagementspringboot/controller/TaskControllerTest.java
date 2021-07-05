package de.ovsiannikov.taskmanagementspringboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ovsiannikov.taskmanagementspringboot.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;

import static de.ovsiannikov.taskmanagementspringboot.prototype.TaskPrototype.*;
import static de.ovsiannikov.taskmanagementspringboot.prototype.TasksListPrototype.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaskService taskService;


    @Test
    void create() throws Exception {
        when(taskService.create(
                taskDtoFromFrontEnd().getName(),
                taskDtoFromFrontEnd().getDescription(),
                taskDtoFromFrontEnd().getDueDate()))
                .thenReturn(taskFromDB());

        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDtoFromFrontEnd())))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(taskFromDB())));

        verify(taskService,times(1)).create(
                taskDtoFromFrontEnd().getName(),
                taskDtoFromFrontEnd().getDescription(),
                taskDtoFromFrontEnd().getDueDate());
    }

    @Test
    void create_with_wrong_dueDate() throws Exception {
        when(taskService.create(
                taskDtoFromFrontEnd().getName(),
                taskDtoFromFrontEnd().getDescription(),
                taskDtoFromFrontEnd().getDueDate()))
                .thenThrow(new RuntimeException());
        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskWithInvalidDate())))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_with_empty_name() throws Exception {
        when(taskService.create(
                taskWithoutName().getName(),
                taskWithoutName().getDescription(),
                taskWithoutName().getDueDate()))
                .thenThrow(new RuntimeException());
        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskWithoutName())))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    void getAll() throws Exception {
        when(taskService.getSortedTasksList()).thenReturn(sortedListByDueDateWith4Tasks());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(unsortedListByDueDateWith4Tasks())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(sortedListByDueDateWith4Tasks())));

        verify(taskService,times(1)).getSortedTasksList();

    }

    @Test
    void getAll_notFound() throws Exception {
        when(taskService.getSortedTasksList()).thenReturn(Collections.emptyList());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.emptyList())));

        verify(taskService,times(1)).getSortedTasksList();
    }

    @Test
    void getById() throws Exception {
        when(taskService.getById(1)).thenReturn(taskFromDB());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/{id}",1)
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString("1")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(taskFromDB())));

        verify(taskService,times(1)).getById(1);
    }
}
