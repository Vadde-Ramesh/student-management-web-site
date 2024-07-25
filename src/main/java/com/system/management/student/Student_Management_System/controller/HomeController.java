package com.system.management.student.Student_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.management.student.Student_Management_System.Repository.CoursesRepository;
import com.system.management.student.Student_Management_System.Repository.StudentCourseRepository;
import com.system.management.student.Student_Management_System.Service.Admin_Service;
import com.system.management.student.Student_Management_System.Service.EmployeeService;
import com.system.management.student.Student_Management_System.Service.Student_Service;
import com.system.management.student.Student_Management_System.entity.Admin;
import com.system.management.student.Student_Management_System.entity.Courses;
import com.system.management.student.Student_Management_System.entity.Employee;
import com.system.management.student.Student_Management_System.entity.Student;
import com.system.management.student.Student_Management_System.entity.StudentCourse;




@Controller
@RequestMapping
public class HomeController {
	@Autowired
	private StudentCourseRepository scr;
	@Autowired
	private CoursesRepository course;	
	@Autowired
	private Student_Service std;
    @Autowired
	private EmployeeService empser;
	@Autowired
	private Admin_Service adminService;
	
	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/log-in")
	public String getMethodName(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "log-in";
	}
	
	@GetMapping("/admin-login")
	public String adminLogin(@ModelAttribute("admin") Admin admin , Model model) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		if(adminService.existsByEmailAndPassword(email, password)) {
			Admin admin1 = adminService.findByEmailAndPassword(email, password);
			model.addAttribute("admin", admin1);
			model.addAttribute("employee", empser.findAll());
			model.addAttribute("courses", scr.findAll());
			model.addAttribute("course", course.findAll());
		   return "admin-page";
		   }
		else if(std.existsByEmailAndPassword(email, password)) {
			Student student1 = std.findByEmailAndPassword(email, password);
			model.addAttribute("student", student1);
			model.addAttribute("courses", course.findAll());
			Integer studentId = student1.getId();
			String email1 = student1.getEmail();
			if(scr.existsByStudentIdAndStudentEmail(studentId, email1)) {
				model.addAttribute("studentCourse", scr.findByStudentIdAndStudentEmail(studentId, email1));
			}
			return "student-page";
		}
		else if(empser.existsByEmailAndPassword(email, password)) {
			model.addAttribute("mployee", empser.findByEmailAndPassword(email, password));
			model.addAttribute("courses", scr.findAll());
			return "employee-page";
		}
		else {
			return "re-log-in";
		}
	}
	

	@GetMapping("/add-admin")
	public String adminSignUp(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "sign-up";
	}
	@PostMapping("/saveAdmin")
	public String postMethodName(@ModelAttribute("admin") Admin admin, Model model) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		if(adminService.existsByEmailAndPassword(email, password)) {
			return "re-log-in";
		}
		else {
			adminService.save(admin);
			Admin admin1 = adminService.findByEmailAndPassword(email, password);
			model.addAttribute("admin", admin1);
			model.addAttribute("courses", scr.findAll());
			model.addAttribute("employee", empser.findAll());
			model.addAttribute("course", course.findAll());
			return "admin-page";
		}
	}
	
	@GetMapping("/add-employee")
	public String addEmployee(@ModelAttribute("admin") Admin admin, Model model) {
		Employee emp = new Employee();
		model.addAttribute("admin", admin);
		model.addAttribute("employee", emp);
		return "add-employee";
	}
	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute("admin") Admin admin, @ModelAttribute("employee") Employee employee, Model model) {
		String name = employee.getFirstName();
		String lastName = employee.getLastName();
		String password = employee.getPassword();
		String email = employee.getEmail();
		Employee emp1 = new Employee(name, lastName, email, password);
		if(empser.existsByEmail(email)) {
			model.addAttribute("employee", empser.findAll());
			model.addAttribute("courses", scr.findAll());
			model.addAttribute("admin", admin);
			model.addAttribute("course", course.findAll());
			return "admin-page";
		}
		else {
			empser.save(emp1);
			model.addAttribute("employee", empser.findAll());
			model.addAttribute("admin", admin);
			model.addAttribute("courses", scr.findAll());
			model.addAttribute("course", course.findAll());
			return "admin-page";
		}
	}
	@GetMapping("/new-student")
	public String register(Model model) {
		Student student1 = new Student();
		model.addAttribute("student", student1);
		return "register-student";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("student") Student student, Model model) {
		String email = student.getEmail();
		String password= student.getPassword();
		if(std.existsByEmailAndPassword(email, password)) {	
		   return "user-exist";
		   }
		else {
			std.save(student);
			model.addAttribute("student", student);
			model.addAttribute("courses", course.findAll());
		  return "student-page";
		}
	}
	@GetMapping("/buy-course/{courseid}/{studentid}")
	public String addCourse(@PathVariable("courseid") Integer courseid, @PathVariable("studentid") Integer studentid,
			Model model){
		Courses course1 = course.findById(courseid).get();
		Student student1 = std.findById(studentid);
		Integer courseid1 = course1.getId();
		Integer studentid1 = student1.getId();
		String courseName = course1.getCourse();
		String studentName = student1.getFirstName();
		String studentEmail = student1.getEmail();
		StudentCourse scr1 = new StudentCourse(studentid1, courseid1, studentName, studentEmail, courseName);
		scr.save(scr1);
		model.addAttribute("studentCourse", scr.findByStudentId(studentid));
		model.addAttribute("student", student1);
		model.addAttribute("courses", course.findAll());
		return "join-Success";
	}
    @GetMapping("/forgot-password")
	public String forgotPassword(Model model) {
    	Admin admin = new Admin();
    	model.addAttribute("admin", admin);
		return "forgot-password";
	} 
    @GetMapping("/change-password")
	public  String changePassword(@ModelAttribute("admin") Admin admin, Model model) {
		String email = admin.getEmail();
		String password = admin.getPassword();
    	if(adminService.existsByEmail(email)) {
			Admin admin1 = adminService.findByEmail(email);
			admin1.setPassword(password);
			adminService.save(admin1);
			model.addAttribute("admin", admin1);
			model.addAttribute("employee", empser.findAll());
			model.addAttribute("courses", scr.findAll());
			model.addAttribute("course", course.findAll());
			return "admin-page";
		}
    	else if(empser.existsByEmail(email)) {
    		Employee emp = empser.findByEmail(email);
			emp.setPassword(password);
			empser.save(emp);
			model.addAttribute("employee", emp);
			model.addAttribute("courses", scr.findAll());
			return "employee-page";
    	}
    	else if(std.existsByEmail(email)) {
    		Student student = std.findByEmail(email);
			student.setPassword(password);
			std.save(student);
			model.addAttribute("student", student);
			model.addAttribute("courses", course.findAll());
			return "student-page";
    	}
		return "redirect:home";
	}
	
    @GetMapping("/course/{id}/{id1}")
    public String editCourse(@PathVariable("id") Integer id,@PathVariable("id1") Integer id1, Model model) {
    	model.addAttribute("admin", adminService.findById(id1));
    	model.addAttribute("course", course.findById(id));
        return "edit-course";
    }
    @PostMapping("/course-edit/{id}")
    public String edit_course(@ModelAttribute("courses") Courses courses, @PathVariable("id") Integer id, Model model) {
    	Integer id1 = courses.getId();
    	String name = courses.getCourse();
    	double price = courses.getPrice();
    	Courses course1 = new Courses(id1, name, price);
    	course.save(course1);
        Admin admin1 = adminService.findById(id);
        model.addAttribute("admin", admin1);
		model.addAttribute("employee", empser.findAll());
		model.addAttribute("courses", scr.findAll());
		model.addAttribute("course", course.findAll());
    	return "admin-page";
    }
    @GetMapping("/course-delete/{id}/{id1}")
    public String deleteRecord(@PathVariable("id") Integer id, @PathVariable("id1") Integer id1, Model model) {
    	Courses course1 = course.findById(id).get();
    	course.delete(course1);
    	Admin admin1 = adminService.findById(id1);
    	model.addAttribute("admin", admin1);
		model.addAttribute("employee", empser.findAll());
		model.addAttribute("courses", scr.findAll());
		model.addAttribute("course", course.findAll());
    	return "admin-page";
    }
    @GetMapping("/emp-delete/{id}/{id1}")
    public String delete_emp(@PathVariable("id") Integer id, @PathVariable("id1") Integer id1, Model model) {
    	Employee emp = empser.findById(id); 
    	Admin admin1 = adminService.findById(id1);
    	empser.delete(emp);
    	model.addAttribute("admin", admin1);
		model.addAttribute("employee", empser.findAll());
		model.addAttribute("courses", scr.findAll());
		model.addAttribute("course", course.findAll());
    	return "admin-page";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
