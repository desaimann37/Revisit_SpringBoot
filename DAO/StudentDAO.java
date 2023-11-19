package com.example.Spring.security.DAO;

import java.util.List;

import com.example.Spring.security.entity.Student;

public interface StudentDAO {

	void save(Student student);
	Student findById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
	void update(Student student);
}
