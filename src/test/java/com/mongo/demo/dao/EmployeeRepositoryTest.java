package com.mongo.demo.dao;

import com.mongo.demo.entity.Address;
import com.mongo.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.Assert;

import java.util.UUID;

@DataMongoTest
public class EmployeeRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testEmployeeExistsAfterAdding() {

        Employee alex = new Employee();
        alex.setName("Alex");
        alex.setEmail("alex@aol.com");
        Address alexAddress = new Address();
        alexAddress.setCity("Hyd");
        alexAddress.setState("Telangana");
        alex.setAddress(alexAddress);

        UUID id = mongoTemplate.save(alex, "employees").getId();

        Employee actualAlex = mongoTemplate.findById(id.toString(), Employee.class, "employees");
        Assert.notNull(actualAlex, "actualAlex must not be null");

    }

}
