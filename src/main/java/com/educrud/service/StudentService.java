package com.educrud.service;

import com.educrud.model.Student;
import com.educrud.model.StudentRegistration;
import com.educrud.model.Teacher;
import com.educrud.repository.StudentRegistrationRepository;
import com.educrud.repository.StudentRepository;
import com.educrud.repository.TeacherRepository;
import com.educrud.wrapper.StudentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

	public static final String STATUS = "status";
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;
	
	public Map<String, Object> saveStudent(StudentWrapper inputStudent) {
		Map<String, Object>  statusMap = new HashMap<>();
		Student student = new Student();

		try {
			student.setName(inputStudent.getName());
			student.setEmail(inputStudent.getEmail());

			student = (Student) studentRepository.save(student);

			inputStudent.setId(student.getId());
			inputStudent.setName(student.getName());
			inputStudent.setEmail(student.getEmail());
			statusMap.put("student", inputStudent);
		}catch (Exception e){
			statusMap.put("errorMsg : ", "unexpected processing issue");
			e.printStackTrace();
		}
		return statusMap;
		
	}
	
	public Map<String, Object> getStudent(List<String> emails) {
		Map<String, Object>  statusMap = new HashMap<>();
		List<String> studentList = new ArrayList<>();
		statusMap.put("students", studentList);

		try {
			List<Student> commStudents = studentRepository.findByEmailS(emails);
			List<String> emailList = commStudents.stream().map(s -> s.getEmail()).collect(toList());
			if( emails.size() > 1) {
				studentList = emailList.stream().filter(s -> Collections.frequency(emailList, s) > 1).distinct().collect(toList());
				statusMap.put("students", studentList);
			}
			else{
				statusMap.put("students", emailList);
			}
		} catch (Exception e) {
			statusMap.put("errorMsg : ", "unexpected processing issue");
			e.printStackTrace();
		}

		return statusMap;
	}
}
