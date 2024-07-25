package com.system.management.student.Student_Management_System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="student_id")
	private Integer studentId;

	@Column(name="course_id")
	private Integer courseId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_email")
	private String studentEmail;
	
	@Column(name="course_name")
	private String courseName;
	
	public StudentCourse(Integer studentId, Integer courseId, String studentName, String studentEmail,
			String courseName) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.courseName = courseName;
	}
	public StudentCourse() {
		super();
	}
	@Override
	public String toString() {
		return "StudentCourse [studentId=" + studentId + ", courseId=" + courseId + ", studentName=" + studentName
				+ ", studentEmail=" + studentEmail + ", courseName=" + courseName + "]";
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
}
