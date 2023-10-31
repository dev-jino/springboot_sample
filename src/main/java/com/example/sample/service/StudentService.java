package com.example.sample.service;

import com.example.sample.model.Student;

import java.util.List;

public interface StudentService {
  List<Student> getAllStudent();
  Student getStudentById(int id);
  void addStudent(Student student);
  void modifyStudent(Student student);
  void removeStudent(int id);
}
