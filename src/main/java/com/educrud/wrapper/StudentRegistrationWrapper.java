package com.educrud.wrapper;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
public class StudentRegistrationWrapper {
	private long id;
	private String teacher;
	private List<String> student;
}
