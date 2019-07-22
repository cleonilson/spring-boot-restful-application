package com.skynet.springbootrestapplication.repository;

import com.skynet.springbootrestapplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
