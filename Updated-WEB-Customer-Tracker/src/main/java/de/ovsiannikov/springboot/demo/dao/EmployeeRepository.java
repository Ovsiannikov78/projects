package de.ovsiannikov.springboot.demo.dao;

import java.util.List;

import de.ovsiannikov.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// add a method to sort by last name
	List<Employee> findAllByOrderByLastNameAsc();

	// search by name
	List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
