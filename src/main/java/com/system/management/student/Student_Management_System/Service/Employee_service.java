package com.system.management.student.Student_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.management.student.Student_Management_System.Repository.EmployeeRepository;
import com.system.management.student.Student_Management_System.entity.Employee;

@Service
public class Employee_service implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public boolean existsByEmailAndPassword(String email, String password) {
		return emprepo.existsByEmailAndPassword(email, password);
	}

	@Override
	public Employee findByEmailAndPassword(String email, String password) {
		return emprepo.findByEmailAndPassword( email, password);
	}

	@Override
	public boolean existsByFirstNameAndEmail(String name, String email) {
		return existsByFirstNameAndEmail(name, email);
	}

	@Override
	public void save(Employee employee) {
		emprepo.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return emprepo.findAll();
	}

	@Override
	public boolean existsByEmail(String email) {
		return emprepo.existsByEmail(email);
	}

	@Override
	public Employee findByEmail(String email) {
		return emprepo.findByEmail(email);
	}

	@Override
	public Employee findById(Integer id) {
		return emprepo.findById(id).get();
	}

	@Override
	public void delete(Employee emp) {
		emprepo.delete(emp);
	}

	

}
