package com.skynet.springbootrestapplication.resource;

import com.skynet.springbootrestapplication.model.Employee;
import com.skynet.springbootrestapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return service.findById(id).map(employee -> ResponseEntity.ok(employee)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return service.findById(id).map(employee -> {
            employee.setEmail(newEmployee.getEmail());
            employee.setUsername(newEmployee.getUsername());
            employee.setPassword(newEmployee.getPassword());
            return ResponseEntity.ok(service.save(employee));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return service.findById(id).map(employee -> {
            service.delete(employee);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
