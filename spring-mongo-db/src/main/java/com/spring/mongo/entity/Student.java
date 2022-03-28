package com.spring.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    @Field(name = "mail")
    private String email;

    @DBRef
    private Department department;

    @DBRef
    private List<Subject> subjects;

}
