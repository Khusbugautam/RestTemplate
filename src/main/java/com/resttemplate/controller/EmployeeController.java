package com.resttemplate.controller;

import com.resttemplate.dto.EmployeeDto;
import com.resttemplate.dto.EmployeeResponse;
import com.resttemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EmployeeTest")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/")
    public EmployeeResponse getAllEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();

    }
}
