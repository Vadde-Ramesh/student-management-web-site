package com.system.management.student.Student_Management_System.Service;

import java.util.List;
import com.system.management.student.Student_Management_System.entity.Employee;

public interface EmployeeService {

	boolean existsByEmailAndPassword(String email, String password);

	Employee findByEmailAndPassword(String email, String password);

	boolean existsByFirstNameAndEmail(String name, String email);

	void save(Employee employee);

	List<Employee> findAll();

	boolean existsByEmail(String email);

	Employee findByEmail(String email);

	Employee findById(Integer id);

	void delete(Employee emp);


}
