package com.educrud.repository;


import com.educrud.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	Student findByEmail(String email);
	Student findById(long id);

	@Query(value = "select s.* From teacher t, student s, student_registration sr where 1=1 and t.teacher_id = sr.teacher_id and s.student_id = sr.student_id and t.email in (?1)", nativeQuery = true)
	List<Student> findByEmailS(List<String> emails);

}
