package com.system.management.student.Student_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.management.student.Student_Management_System.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	boolean existsByEmailAndPassword(String email, String password);

	Employee findByEmailAndPassword(String email, String password);

	boolean existsByFirstNameAndEmail(String name, String email);

	boolean existsByEmail(String email);

	Employee findByEmail(String email);
}
