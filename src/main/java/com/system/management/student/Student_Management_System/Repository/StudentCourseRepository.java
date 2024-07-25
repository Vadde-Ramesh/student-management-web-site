package com.system.management.student.Student_Management_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.management.student.Student_Management_System.entity.StudentCourse;
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

	List<StudentCourse> findByStudentId(Integer studentid);

	List<StudentCourse> findByStudentIdAndStudentEmail(Integer studentId, String email1);

	boolean existsByStudentIdAndStudentEmail(Integer studentId, String email1);

}
