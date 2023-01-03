package com.resttemplate.service;

import com.resttemplate.dto.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeResponse getAllEmployeeDetails();
}
