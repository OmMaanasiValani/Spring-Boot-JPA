package com.employee.maintain.employee_crud.controller;

import com.employee.maintain.employee_crud.models.Employee;
import com.employee.maintain.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeControllerv2 {
    @Qualifier("employeeServiceImplv2")
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();

    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id){
        return employeeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return employeeService.delete(id);
    }
}
