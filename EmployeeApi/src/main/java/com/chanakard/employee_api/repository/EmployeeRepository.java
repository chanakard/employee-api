package com.chanakard.employee_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chanakard.employee_api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Page<Employee> findAll(Pageable pageable);
}
