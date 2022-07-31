package com.educrud.service;

import com.educrud.model.Student;
import com.educrud.model.StudentRegistration;
import com.educrud.model.Teacher;
import com.educrud.repository.StudentRegistrationRepository;
import com.educrud.repository.StudentRepository;
import com.educrud.repository.TeacherRepository;
import com.educrud.wrapper.StudentRegistrationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository repository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public Map<String, Object> registerStudent(StudentRegistrationWrapper inputStudent) {
		Map<String, Object>  statusMap = new HashMap<>();
		List<String> students = inputStudent.getStudent();

		Teacher teacher = teacherRepository.findByEmail(inputStudent.getTeacher());

		try {
			students.forEach(student -> {
						StudentRegistration studentRegistration = new StudentRegistration();
						Student studentIterate = studentRepository.findByEmail(student);
						studentRegistration.setStudentid(studentIterate.getId());
						studentRegistration.setTeacherid(teacher.getId());
						repository.save(studentRegistration);
					}
			);
			statusMap.put("StudentRegistration ", "Successfully fulfilled the request");
		} catch(Exception e){
			statusMap.put("errorMsg : ", "unexpected processing issue");
			e.printStackTrace();
		}
		
		return statusMap;
	}

	
}
