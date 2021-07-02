package de.ovsiannikov.taskmanagementspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TaskManagementSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementSpringBootApplication.class, args);
    }

}
