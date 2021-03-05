package com.mongo.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document(collection = "books")
public class Employee {

    @Id
    private UUID id;
    private String name;
    private Address address;

    @Indexed(unique = true)
    private String email;

}
