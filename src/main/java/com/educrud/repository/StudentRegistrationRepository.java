package com.educrud.repository;

import com.educrud.model.StudentRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRegistrationRepository extends CrudRepository<StudentRegistration, Long>{
	List<StudentRegistration> findAllById(long id);
	List<StudentRegistration> findAllByTeacherId(long id);
	List<StudentRegistration> findAllByStudentId(long id);
}

