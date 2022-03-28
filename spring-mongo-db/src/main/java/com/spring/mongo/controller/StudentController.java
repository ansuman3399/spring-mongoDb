package com.spring.mongo.controller;

import com.spring.mongo.entity.Student;
import com.spring.mongo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        log.info("saved student is : {}", savedStudent);
        return savedStudent;
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        Student savedStudent = studentService.getStudentById(id);
        log.info("Student fetched by ID is : {}", savedStudent);
        return savedStudent;
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        log.info("All students are : {}", students);
        return students;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        log.info("Updated student is: {}", updatedStudent);
        return updatedStudent;
    }

    @DeleteMapping("/delete/{id}")
    public void updateStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        log.info("Deleted student with id: {}", id);
    }

    @GetMapping("/getByNameAndEmail")
    public Student getByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getByNameAndEmail(name, email);
    }

    @GetMapping("/getByNameOrEmail")
    public List<Student> getByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getByNameOrEmail(name, email);
    }

    @GetMapping("/getAllByPagination")
    public List<Student> getAllByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.getAllByPagination(pageNo,pageSize);
    }

    @GetMapping("/getAllWithSorting")
    public List<Student> getAllWithSorting() {
        return studentService.getAllWithSorting();
    }

    @GetMapping("/getByDepartmentName")
    public List<Student> getByDepartmentName(@RequestParam String departmentName) {
        return studentService.getByDepartmentName(departmentName);
    }
}
