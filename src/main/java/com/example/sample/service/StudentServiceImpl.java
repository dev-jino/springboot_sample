package com.example.sample.service;

import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudent() {
    return studentRepository.selectAllStudent();
  }

  @Override
  public Student getStudentById(int id) {
    return studentRepository.selectStudentById(id);
  }

  @Override
  public void addStudent(Student student) {
    studentRepository.insertStudent(student);
  }

  @Override
  public void modifyStudent(Student student) {
    studentRepository.updateStudent(student);
  }

  @Override
  public void removeStudent(int id) {
    studentRepository.deleteStudent(id);
  }
}
