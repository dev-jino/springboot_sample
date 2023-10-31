package com.example.sample.repository;

import com.example.sample.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {
  List<Student> selectAllStudent();
  Student selectStudentById(int id);
  void insertStudent(Student student);
  void updateStudent(Student student);
  void deleteStudent(int id);
}
