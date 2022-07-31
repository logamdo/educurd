package com.educrud.model;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "student_registration")
public class StudentRegistration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "student_id")
	private long studentid;
	
	@Column(name = "teacher_id")
	private long teacherid;
	
	//	@ManyToOne (cascade = {CascadeType.ALL})
	@ManyToOne
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private Student student;
	
//	@ManyToOne (cascade = {CascadeType.ALL})
	@ManyToOne
	@JoinColumn(name = "teacher_id", insertable = false, updatable = false)
	private Teacher teacher;

}
