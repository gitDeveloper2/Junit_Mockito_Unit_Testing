package com.gitDeveoper.Testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.gitDeveoper.Testing.student.Student;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where age=40", nativeQuery = true)
    List<Student> getStudentAtAge40();
    Boolean selectExistsName(String name);
}
