package com.educrud.service;

import com.educrud.model.Teacher;
import com.educrud.repository.TeacherRepository;
import com.educrud.wrapper.TeacherWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	public Map<String, Object> saveTeacher(TeacherWrapper inputTeacher) {
		Map<String, Object>  statusMap = new HashMap<>();
		Teacher teacher = new Teacher();
		try {
			teacher.setName(inputTeacher.getName());
			teacher.setEmail(inputTeacher.getEmail());

			teacher = (Teacher) repository.save(teacher);

			inputTeacher.setId(teacher.getId());
			inputTeacher.setName(teacher.getName());
			inputTeacher.setEmail(teacher.getEmail());
			statusMap.put("teacher", inputTeacher);
		} catch (Exception e){
			statusMap.put("errorMsg : ", "unexpected processing issue");
			e.printStackTrace();
		}
		return statusMap;
	}
}
