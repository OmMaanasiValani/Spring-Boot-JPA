package com.employee.maintain.employee_crud.service;

import com.employee.maintain.employee_crud.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee e);
    List<Employee> getAll();

    Employee getById(String id);

    String delete(String id);

}
