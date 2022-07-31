package com.educrud.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private long id;

@NotNull
	@Column(name = "name")
	private String name;

@NotNull
	@Column(name ="email", unique=true)
	private String email;


	//@ManyToOne
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "student_id")
	private List<StudentRegistration> studentRegistration;


	public Teacher() {

	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + "]";
	}


}
