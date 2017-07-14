package com.inn.hibernateSpring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.inn.hibernateSpring.dao.IStudentDao;
import com.inn.hibernateSpring.model.Student;

public class StudentDaoImpl implements IStudentDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	@Override
	public Student add(Student student) {
		hibernateTemplate.save(student);
		return student; 
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		Student student= hibernateTemplate.load(Student.class, id);
		hibernateTemplate.delete(student);
		hibernateTemplate.flush();
		
		return false;
	}

	@Transactional
	@Override
	public Student search(int id) {
		Student student= hibernateTemplate.load(Student.class, id);
		return student;
	}

	@Transactional
	@Override
	public Student update(Student student) {
		hibernateTemplate.saveOrUpdate(student);
		return student;
	}

	@Override
	public List<Student> getAll() {
		return hibernateTemplate.loadAll(Student.class);
	}

}
