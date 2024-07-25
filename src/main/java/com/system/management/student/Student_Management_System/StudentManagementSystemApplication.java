package com.system.management.student.Student_Management_System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.system.management.student.Student_Management_System.Repository.Admin_Repository;
import com.system.management.student.Student_Management_System.Repository.CoursesRepository;
import com.system.management.student.Student_Management_System.Repository.EmployeeRepository;
import com.system.management.student.Student_Management_System.Service.Student_Service;
import com.system.management.student.Student_Management_System.entity.Admin;
import com.system.management.student.Student_Management_System.entity.Courses;
import com.system.management.student.Student_Management_System.entity.Employee;
import com.system.management.student.Student_Management_System.entity.Student;



@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{
	@Autowired
	private Admin_Repository adrepo;
	
	private CoursesRepository cosrepo;
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired
	private Student_Service stu;
	@Autowired
	private EmployeeRepository emp;

	public StudentManagementSystemApplication(CoursesRepository cosrepo) {
		super();
		this.cosrepo = cosrepo;
	}


	@Override
	public void run(String... args) throws Exception {
		Admin admin1 = new Admin("Admin", "admin","admin@gmail.com", "admin@123");
		adrepo.save(admin1);
		
		Courses course1 = new Courses("Java Full Stack", 8000);
		Courses course2 = new Courses("Python Full Stack", 5000);
		Courses course3 = new Courses(".net Full Stack", 6000);
		Courses course4 = new Courses("C++ Full Stack", 7000);
		Courses course5 = new Courses("JavaScript Full Stack", 7000);
	    cosrepo.save(course1);
	    cosrepo.save(course2);
	    cosrepo.save(course3);
	    cosrepo.save(course4);
	    cosrepo.save(course5);
	    
	    Student student1 = new Student("Ram", "kumar", "student@gmail.com", "student@123");
	    stu.save(student1);
	    
	    Employee emp1 =new Employee("employee", "employee", "employee@gmail.com", "emp@123");
	    emp.save(emp1);
	}

	

}
