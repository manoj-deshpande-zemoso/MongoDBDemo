package com.mongo.demo.controller;

import com.mongo.demo.dao.EmployeeRepository;
import com.mongo.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()) return null;
        return employee.get();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "id") UUID id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity("Successfully deleted employee with id " + id, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable(name = "email") String email) {
        return employeeRepository.findByEmail(email);
    }

    @GetMapping("/email/like/{email}")
    public List<Employee> getEmployeeWithEmailLike(@PathVariable(name = "email") String email) {
        return employeeRepository.findByEmailContainingIgnoreCase(email);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable(name = "name") String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping("/name/like/{name}")
    public List<Employee> getEmployeesWithNameLike(@PathVariable(name = "name") String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/address/like/{address}")
    public List<Employee> getEmployeesWithAddressLike(@PathVariable(name = "address") String address) {
        return employeeRepository.findByAddressContainingString(address);
    }

    @GetMapping("/emailorname/{text}")
    public List<Employee> getEmployeesWithEmailOrName(@PathVariable(name = "text") String text) {
        return employeeRepository.findByNameOrEmailCustomQuery(text);
    }

}
