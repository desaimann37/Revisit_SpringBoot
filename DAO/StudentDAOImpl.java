package com.example.Spring.security.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Spring.security.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
		return;
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student>theQuery = entityManager.createQuery("FROM Student order by firstName" , Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lName) {
		// TODO Auto-generated method stub
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData" , Student.class);
		theQuery.setParameter("theData", lName);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		// TODO Auto-generated method stub
		entityManager.merge(student);
		return;
	}
}
