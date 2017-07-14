package com.inn.hibernateSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inn.hibernateSpring.dao.IStudentDao;
import com.inn.hibernateSpring.model.Student;
import com.inn.hibernateSpring.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentDao studentDao;
	
	@Override
	public Student add(Student student) {
		
		return studentDao.add(student);
	}

	@Override
	public boolean delete(int id) {
		
		return studentDao.delete(id);
	}

	@Override
	public Student search(int id) {
		
		return studentDao.search(id);
	}

	@Override
	public Student update(Student student) {
		
		return studentDao.update(student);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

}
