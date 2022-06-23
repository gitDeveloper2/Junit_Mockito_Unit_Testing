package com.gitDeveoper.Testing;

import com.gitDeveoper.Testing.StudentRepo;
import com.gitDeveoper.Testing.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student saveStudent(Student student){
        boolean result=studentRepo.selectExistsName(student.getName());
        if(result){
            throw new IllegalArgumentException("Error");
        }
       return studentRepo.save(student);


    }
    public List<Student> getStudentAtAge40(){
        return (List<Student>) studentRepo.getStudentAtAge40();
    }
}
