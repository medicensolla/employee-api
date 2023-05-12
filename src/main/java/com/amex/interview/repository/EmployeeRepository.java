package com.amex.interview.repository;

import com.amex.interview.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    Employee getEmployeeByName(String name);



}
