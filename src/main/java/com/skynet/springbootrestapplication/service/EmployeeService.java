package com.skynet.springbootrestapplication.service;

import com.skynet.springbootrestapplication.model.Employee;
import com.skynet.springbootrestapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void delete(Employee employee) {
        repository.delete(employee);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

}
