package com.inn.hibernateSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inn.hibernateSpring.model.Student;
import com.inn.hibernateSpring.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	String message;
	private static int counter;
	
	@RequestMapping("/add.htm")
	public ModelAndView add(){
		System.out.println("add() called");
		message = "Student added successfully";
		Student student = new Student("Atul "+counter++, 28);
		student = studentService.add(student);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("MESSAGE", message);
		return modelAndView;
	}
	@RequestMapping("/delete.htm")
	public ModelAndView delete(){
		System.out.println("delete() called");
		message = "Student deleted successfully";
		studentService.delete(1);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("MESSAGE", message);
		return modelAndView;
	}
	
	@RequestMapping("/search.htm")
	public ModelAndView search(){
		System.out.println("search() called");
		message = "Student search successfully";
		Student student = studentService.search(1);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("MESSAGE", message);
		return modelAndView;
	}
	
	@RequestMapping("/update.htm")
	public ModelAndView update(){
		System.out.println("update() called");
		message = "Student updated successfully";
		Student student = new Student(1,"Atul Singh", 28);
		student = studentService.update(student);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("MESSAGE", message);
		return modelAndView;
	}
	@RequestMapping("/getAll.htm")
	public ModelAndView getAll(){
		System.out.println("getAll() called");
//		message = "Student getAll called successfully";
		List<Student> students = studentService.getAll();
		 message="<table><tr><th>ID</th><th>Name</th><th>Age</th></tr>";
		for(Student student: students){
			message +="<tr><td>"+student.getId()+"</td><td>"+student.getName()+"</td><td>"+student.getAge()+"</td></tr>";
		}
		message +="</table>";
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("MESSAGE", message);
		return modelAndView;
	}
}
