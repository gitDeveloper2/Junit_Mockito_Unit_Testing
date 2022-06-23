package com.gitDeveoper.Testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gitDeveoper.Testing.student.Student;


import java.util.List;

@RestController
public class Controller {
    @Autowired
    StudentService studentService;
    @GetMapping("/get")
    public List<Student> get(){
        return studentService.getStudentAtAge40();
    }
    @PostMapping("/post")
    public Student post(@RequestBody Student student) throws Exception {
        return studentService.saveStudent(student);
    }

}

