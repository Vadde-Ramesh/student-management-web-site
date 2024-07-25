package com.system.management.student.Student_Management_System.Service;

import com.system.management.student.Student_Management_System.entity.Student;

public interface Student_Service {

	boolean existsByEmailAndPassword(String email, String password);

	Student findByEmailAndPassword(String email, String password);

	void save(Student student);

	Student findById(Integer studentid);

	boolean existsByEmail(String email);

	Student findByEmail(String email);



}
