package com.mongo.demo.dao;

import com.mongo.demo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends MongoRepository<Employee, UUID> {

    public Employee findByEmail(String email);

    public List<Employee> findByEmailContainingIgnoreCase(String email);

    public List<Employee> findByName(String name);

    public List<Employee> findByNameContainingIgnoreCase(String name);

    @Query("{ '$or': [ { 'name': /?0/ }, { 'email': /?0/ }]}")
    public List<Employee> findByNameOrEmailCustomQuery(String name);

    @Query("{ $or: [ { 'address.city': /?0/ }, { 'address.state': /?0/ }, { 'address.district': /?0/ } ]}")
    public List<Employee> findByAddressContainingString(String address);

}
