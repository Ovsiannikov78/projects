package de.ovsiannikov.taskmanagementspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    public int id;

    @NotBlank(message = "Name is mandatory")
    public String name;

    public String description;

    @Future(message = "The date can't be in the past. Please provide a valid date.")
    public LocalDateTime dueDate;

}
