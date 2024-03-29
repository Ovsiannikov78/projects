package de.ovsiannikov.springboot.demo.service;

import java.util.List;

import de.ovsiannikov.springboot.demo.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

    public List<Employee> searchBy(String theName);

}
