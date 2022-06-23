package com.gitDeveoper.Testing;

import com.gitDeveoper.Testing.student.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepo studentRepo;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest=new StudentService(studentRepo);
    }

    @Test
    void canSaveStudent() throws Exception {
        //condition
        Student student=new Student("rachael",40);
        //implementation
        underTest.saveStudent(student);
        //test
        ArgumentCaptor<Student> studentArgumentCaptor=ArgumentCaptor.forClass(Student.class);
        verify(studentRepo).save(studentArgumentCaptor.capture());
        Student captured=studentArgumentCaptor.getValue();
        assertThat(captured).isEqualTo(student);

    }
    @Test
    void canThrowIllegalArgumentException() {
        //condition
        Student student=new Student("rachael",40);
        //implementation
        given(studentRepo.selectExistsName(anyString())).willReturn(true);

        assertThatThrownBy(()->underTest.saveStudent(student)).isInstanceOf(IllegalArgumentException.class).hasMessage("Error");
        verify(studentRepo,never()).save(any());
        //


    }

    @Test
    void canGetStudentAtAge40() {
        //condition and implementation
        underTest.getStudentAtAge40();
        //test
        verify(studentRepo).getStudentAtAge40();

    }
}