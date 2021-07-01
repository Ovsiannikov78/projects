package de.ovsiannikov.taskmanagementspringboot.repository;

import de.ovsiannikov.taskmanagementspringboot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

   Optional<List<Task>> findAllByOrderByDueDateAsc();

   @Transactional
   Integer deleteTasksByDueDateBefore(LocalDateTime currentDate);
}
