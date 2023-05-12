package com.amex.interview.controller;

import com.amex.interview.dto.EmployeeDto;
import com.amex.interview.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto responseEmployeeDto = employeeService.createEmployee(employeeDto);

        return new ResponseEntity(responseEmployeeDto,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeDto employeeDto) {

        EmployeeDto employeeDtoResponse = employeeService.updateEmployee(id, employeeDto);

        return new ResponseEntity<>(employeeDtoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id")Integer id){


        employeeService.deleteEmployee(id);


        return new ResponseEntity<>(HttpStatus.OK);


    }


    @GetMapping(path = "/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();

        return ResponseEntity.ok().body(employeeDtoList);

    }


}
