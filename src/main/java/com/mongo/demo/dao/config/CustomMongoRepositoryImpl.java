package com.mongo.demo.dao.config;

import com.mongo.demo.entity.Employee;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;
import java.util.UUID;

public class CustomMongoRepositoryImpl extends SimpleMongoRepository<Employee, UUID> {
    public CustomMongoRepositoryImpl(MongoEntityInformation<Employee, UUID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }

    @Override
    public <S extends Employee> S insert(S entity) {
        generateId(entity);
        return super.insert(entity);
    }

    @Override
    public <S extends Employee> List<S> insert(Iterable<S> entities) {
        for(Employee emp : entities)
            generateId(emp);
        return super.insert(entities);
    }

    @Override
    public <S extends Employee> S save(S entity) {
        generateId(entity);
        return super.save(entity);
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        for(Employee emp : entities)
            generateId(emp);
        return super.saveAll(entities);
    }

    private void generateId(Employee emp) {
        if(emp.getId() == null)
            emp.setId(UUID.randomUUID());
    }
}
