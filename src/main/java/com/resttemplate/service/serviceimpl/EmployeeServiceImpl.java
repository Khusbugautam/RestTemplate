package com.resttemplate.service.serviceimpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resttemplate.dto.EmployeeDto;
import com.resttemplate.dto.EmployeeResponse;
import com.resttemplate.entity.Employee;
import com.resttemplate.repository.EmployeeRepository;
import com.resttemplate.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }



    @Override
    public EmployeeResponse getAllEmployeeDetails() {
        log.info("Get All Employees Details requested");
       List<Employee> employees= employeeRepository.findAll();
      List<EmployeeDto> employeeList = new ArrayList<>();
      employees.forEach(employee -> employeeList.add(objectMapper.convertValue(employees, new TypeReference<EmployeeDto>() {
  })));
      EmployeeResponse employeeResponse=new EmployeeResponse();
      employeeResponse.setData(employeeList);
      employeeResponse.setSuccess("Success");
      return employeeResponse;




    }
}
