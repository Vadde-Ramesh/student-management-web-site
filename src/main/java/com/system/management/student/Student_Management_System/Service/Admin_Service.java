package com.system.management.student.Student_Management_System.Service;

import com.system.management.student.Student_Management_System.entity.Admin;

public interface Admin_Service {

	boolean existsByEmailAndPassword(String email, String password);

	Admin findByEmailAndPassword(String email, String password);

	Admin save(Admin admin1);

	Admin findById(Integer id1);

	boolean existsByEmail(String email);

	Admin findByEmail(String email);


}
