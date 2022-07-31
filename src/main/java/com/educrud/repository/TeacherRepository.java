package com.educrud.repository;

import com.educrud.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>{

	Teacher findByEmail(String email);

}
