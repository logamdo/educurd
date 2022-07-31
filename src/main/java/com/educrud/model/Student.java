package com.educrud.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_id")
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
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Student(String email){
		this.setEmail(email);
	}
}
