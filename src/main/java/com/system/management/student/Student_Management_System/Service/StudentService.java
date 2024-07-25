package com.system.management.student.Student_Management_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.management.student.Student_Management_System.Repository.StudentRepository;
import com.system.management.student.Student_Management_System.entity.Student;

@Service
public class StudentService implements Student_Service{
	
	@Autowired
	private StudentRepository sturepo;

	@Override
	public boolean existsByEmailAndPassword(String email, String password) {
		return sturepo.existsByEmailAndPassword(email, password);
	}

	@Override
	public Student findByEmailAndPassword(String email, String password) {
		return sturepo.findByEmailAndPassword(email, password);
	}

	@Override
	public void save(Student student) {
		sturepo.save(student);
	}

	@Override
	public Student findById(Integer studentid) {
		return sturepo.findById(studentid).get();
	}

	@Override
	public boolean existsByEmail(String email) {
		return sturepo.existsByEmail(email);
	}

	@Override
	public Student findByEmail(String email) {
		return sturepo.findByEmail(email);
	}

	

}
