package com.system.management.student.Student_Management_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.management.student.Student_Management_System.Repository.Admin_Repository;
import com.system.management.student.Student_Management_System.entity.Admin;
@Service
public  class AdminService  implements Admin_Service{
	
	@Autowired
  private Admin_Repository adminRepo;

	@Override
	public boolean existsByEmailAndPassword(String email, String password) {
		return adminRepo.existsByEmailAndPassword(email , password);
	}

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		return adminRepo.findByEmailAndPassword(email , password);
	}

	@Override
	public Admin save(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public Admin findById(Integer id1) {
		return adminRepo.findById(id1).get();
	}

	@Override
	public boolean existsByEmail(String email) {
		return adminRepo.existsByEmail(email);
	}

	@Override
	public Admin findByEmail(String email) {
		return adminRepo.findByEmail(email);
	}
	
}
