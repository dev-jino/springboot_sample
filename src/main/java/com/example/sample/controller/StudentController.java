package com.example.sample.controller;

import com.example.sample.model.Student;
import com.example.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
  @Autowired
  private StudentService studentService;

  @GetMapping("/list")
  public String getAllStudent(Model model) {
    List<Student> studentList = studentService.getAllStudent();
    model.addAttribute("studentList", studentList);

    return "studentList";
  }

  @GetMapping("/add")
  public String addStudent() {
    return "studentAdd";
  }

  @PostMapping("/add")
  public String addStudent(@ModelAttribute Student student) {
    studentService.addStudent(student);

    return "redirect:list";
  }

  @GetMapping("/modify")
  public String modifyStudent(@RequestParam("studentId") int studentId,
                              Model model) {
    Student studentById = studentService.getStudentById(studentId);
    model.addAttribute("student", studentById);

    return "studentModify";
  }

  @PostMapping("/modify")
  public String modifyStudent(@ModelAttribute Student student,
                              RedirectAttributes redirect) {
    studentService.modifyStudent(student);
    redirect.addAttribute("studentId", student.getStudentId());

    return "redirect:list";
  }

  @GetMapping("/remove")
  public String removeStudent(@RequestParam("studentId") int studentId) {
    studentService.removeStudent(studentId);

    return "redirect:list";
  }
}
