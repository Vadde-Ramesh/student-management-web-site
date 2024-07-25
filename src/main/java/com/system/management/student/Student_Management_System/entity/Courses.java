package com.system.management.student.Student_Management_System.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course_details")
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="course_name")
	private String course;
	@Column(name="course_price")
	private double price;
	
	public Courses(String course, double price) {
		super();
		this.course = course;
		this.price = price;
	}
	
	public Courses() {
		super();
	}

	public Courses(Integer id, String course, double price) {
		super();
		this.id = id;
		this.course = course;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", course=" + course + ", price=" + price + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
