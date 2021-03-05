package com.mongo.demo.entity.id.generator;

import com.mongo.demo.entity.Employee;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeEntityEventListener extends AbstractMongoEventListener<Employee> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Employee> event) {
        Employee emp = event.getSource();
        if(emp.getId() == null)
            emp.setId(UUID.randomUUID());
    }
}
