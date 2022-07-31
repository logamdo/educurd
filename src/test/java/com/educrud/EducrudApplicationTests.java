package com.educrud;

import com.educrud.controller.StudentController;
import com.educrud.model.Student;
import com.educrud.repository.StudentRepository;
import com.educrud.service.StudentService;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class EducrudApplicationTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setMockOutput() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("s3@gmail.com"));
        students.add(new Student("s3@gmail.com"));
        students.add(new Student("s4@gmail.com"));
        students.add(new Student("s6@gmail.com"));
        students.add(new Student("s6@gmail.com"));
        when(studentRepository.findByEmailS(Mockito.anyList())).thenReturn(students);
    }

    @Test
    public void getStudentsRegistered(){
        List<String> emails = new ArrayList<>();
        emails.add("t1@gmail.com");
        emails.add("t2@gmail.com");
        Map<String, Object> student = studentService.getStudent(emails);
        List<String> students = (List<String>) student.get("students");
        assertEquals (2,students.size(),"Test run Failed");
    }
}
