package com.example.Spring.security;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Spring.security.DAO.StudentDAO;
import com.example.Spring.security.entity.Student;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		System.out.println("Project Started...");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return (runner) -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//displayRetrivedObject(studentDAO);
			//queryForStudents(studentDAO);
			//queryToFindStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}
	
	private void deleteStudent(StudentDAO studentDAO) {
		int stdId = 7;
		studentDAO.delete(stdId);
		return;
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student std = studentDAO.findById(studentId);
		System.out.println("Student without Updation : " + std);
		std.setFirstName("Scooby");
		studentDAO.update(std);
		System.out.println("Updated Student : " + std);
	}
	
	
	private void queryToFindStudentByLastName(StudentDAO studentDAO){
		
		List<Student> theStudents = studentDAO.findByLastName("abcd3");
		
		for(Student std : theStudents) {
			System.out.println(std);
		}
	}
	
	private void queryForStudents(StudentDAO studentDAO) {
		List<Student>theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
	
	
	private void displayRetrivedObject(StudentDAO studentDAO) {
		
		Student tempStd = studentDAO.findById(2);
		System.out.println(tempStd.toString());
		
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("aaa" , "abcd2" , "xyzwabcd2@gmail.com");
		Student student2 = new Student("bbb" , "abcd3" , "xyzwabcd3@gmail.com");
		Student student3 = new Student("ccc" , "abcd4" , "xyzwabcd4@gmail.com");
		
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		
		System.out.println("Saved student : Generated Id : " + student1.getId());
		System.out.println("Saved student : Generated Id : " + student2.getId());
		System.out.println("Saved student : Generated Id : " + student3.getId());

	}
	private void createStudent(StudentDAO studentDAO) {
		//create student object : 
		System.out.println("Creating new student object...");
		Student student1 = new Student("xyzw" , "abcd" , "xyzwabcd@gmail.com");
		
		//save the student object :
		System.out.println("Saving the student...");
		studentDAO.save(student1);
		
		//display id of the student recently saved.
		System.out.println("Saved student : Generated Id : " + student1.getId());
	
	}
	
}
