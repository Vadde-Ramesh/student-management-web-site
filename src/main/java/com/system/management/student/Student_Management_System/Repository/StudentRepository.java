package com.system.management.student.Student_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.management.student.Student_Management_System.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	boolean existsByEmailAndPassword(String email, String password);

	Student findByEmailAndPassword(String email, String password);

	boolean existsByEmail(String email);

	Student findByEmail(String email);

}
