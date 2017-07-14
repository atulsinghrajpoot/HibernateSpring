package com.inn.hibernateSpring.dao;

import java.util.List;

import com.inn.hibernateSpring.model.Student;

public interface IStudentDao {

	Student add(Student student);

	boolean delete(int i);

	Student search(int i);

	Student update(Student student);

	List<Student> getAll();

}