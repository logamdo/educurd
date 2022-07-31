package com.educrud.model;

import lombok.Data;

@Data
public class CommonStudents {
	
	long id;
	String email;
	String name;
	@Override
	public String toString() {
		return "CommonStudents [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	
	
}
