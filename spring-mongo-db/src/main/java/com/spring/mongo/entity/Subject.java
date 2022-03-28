package com.spring.mongo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Document(collection = "subject")
public class Subject {

    @Id
    private String id;
    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "marks_obtained")
    private String marksObtained;

}
