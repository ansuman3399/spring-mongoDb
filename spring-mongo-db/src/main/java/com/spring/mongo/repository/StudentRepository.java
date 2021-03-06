package com.spring.mongo.repository;

import com.spring.mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String deptName);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByNameStartsWith(String name);

    @Query("{\"name\": \"?0\"}")
    List<Student> findByNameNativeQuery(String name);
}
