package com.amex.interview.service;

import com.amex.interview.dto.EmployeeDto;
import com.amex.interview.entity.Employee;
import com.amex.interview.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();


        if (Objects.nonNull(employeeDto)) {

            employee.setName(employeeDto.getName());
            employee.setRole(employeeDto.getRole());
            employeeRepository.save(employee);
        }

        return employeeDto;
    }

    public void deleteEmployee(Integer id) {

        Employee employeeToDelete = (employeeRepository.getReferenceById(id));

        if (Objects.nonNull(employeeToDelete)) {

            employeeRepository.delete(employeeToDelete);


        }

    }


    public List<EmployeeDto> getAllEmployees() {
        return fromEmployeeToEmployeeDto(employeeRepository.findAll());
    }


    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {


        Employee updatedEmployee = employeeRepository.getReferenceById(id);

        updatedEmployee.setName(employeeDto.getName());
        updatedEmployee.setRole(employeeDto.getRole());

        employeeRepository.save(updatedEmployee);

        return employeeDto;
    }


    public List<EmployeeDto> fromEmployeeToEmployeeDto(List<Employee> listOfEmployees) {

        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        listOfEmployees.forEach(employee -> employeeDtoList.add(new EmployeeDto(employee.getName(), employee.getRole())));

        return employeeDtoList;


    }
}
