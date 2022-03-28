package com.spring.mongo.service;

import com.spring.mongo.entity.Student;
import com.spring.mongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        if(student.getId().isEmpty())
            throw new IllegalArgumentException("Id is mandatory");
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public Student getByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name,email).get(0);
    }

    public List<Student> getByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name,email);
    }

    public List<Student> getAllByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }

    public List<Student> getByDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }
}
