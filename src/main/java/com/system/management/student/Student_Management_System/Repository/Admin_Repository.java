package com.system.management.student.Student_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.management.student.Student_Management_System.entity.Admin;

@Repository
public interface Admin_Repository  extends JpaRepository<Admin, Integer>{

	boolean existsByEmailAndPassword(String email, String password);

	Admin findByEmailAndPassword(String email, String password);

	Admin findByEmail(String email);

	boolean existsByEmail(String email);

}
