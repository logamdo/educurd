package com.educrud.controller;


import com.educrud.model.Student;
import com.educrud.service.StudentRegistrationService;
import com.educrud.service.StudentService;
import com.educrud.service.TeacherService;
import com.educrud.wrapper.StudentRegistrationWrapper;
import com.educrud.wrapper.StudentWrapper;
import com.educrud.wrapper.TeacherWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentRegistrationService studentRegistrationService;
	
	@PostMapping(value="/students/register")
	@ResponseStatus( HttpStatus.NO_CONTENT )
	public Map<String, Object> studentRegistration(@RequestBody StudentRegistrationWrapper studentRegistrationWrapper){
		return studentRegistrationService.registerStudent(studentRegistrationWrapper);
	}
	
	@PostMapping(value="/students")
	@ResponseStatus( HttpStatus.CREATED )
	public Map<String, Object> saveStudent(@RequestBody StudentWrapper studentWrapper){
			return studentService.saveStudent(studentWrapper);
	}
	
	@PostMapping(value="/teachers")
	@ResponseStatus( HttpStatus.CREATED )
	public Map<String, Object> saveTeacher(@RequestBody TeacherWrapper teacherWrapper){
		return teacherService.saveTeacher(teacherWrapper);
	}
	
	@GetMapping("/commonStudents")
	@ResponseBody
	@ResponseStatus( HttpStatus.OK )
	public Map<String, Object> commonStudents(@RequestParam (name="teacher") List<String> emails){
		 return studentService.getStudent(emails);
	}

}
