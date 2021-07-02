package de.ovsiannikov.taskmanagementspringboot.service;

public interface ExpiredTaskRemoverService {

    Integer removeTaskWithExpiredDueDate();
}
