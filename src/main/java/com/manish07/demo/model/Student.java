package com.manish07.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document ( collection = "students")
public class Student {
    @Id
    private Long id;

    private String name ;

    private int age;

    private String course ;

}
