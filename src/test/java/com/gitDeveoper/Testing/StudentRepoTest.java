package com.gitDeveoper.Testing;

import com.gitDeveoper.Testing.student.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest

class StudentRepoTest {


    @Autowired
private StudentRepo studentRepo;
    @AfterEach
    void tearDown() {
    studentRepo.deleteAll();
    }

    @Test
    void itShouldgetStudentsAtAge40() {
        //conditions
        Student student=new Student("rachael",40);
        studentRepo.save(student);
        //implement
        List<Student> expected=studentRepo.getStudentAtAge40();
        //test
        assertThat(student).isIn(expected);

    }
    @Test
    void itNotShouldgetStudentsNotAtAge40() {
        //conditions
        Student student=new Student("Miriam",50);
        studentRepo.save(student);
        //implement
        List<Student> expected=studentRepo.getStudentAtAge40();
        //test
        assertThat(student).isNotIn(expected);

    }
    @Test
    void itShouldNotgetAnyStudent() {
        //conditions
        List<Student> list= Arrays.asList();
        //implement
        List<Student> expected=studentRepo.getStudentAtAge40();
        //test
        assertThat(expected).isEqualTo(list);

    }
}