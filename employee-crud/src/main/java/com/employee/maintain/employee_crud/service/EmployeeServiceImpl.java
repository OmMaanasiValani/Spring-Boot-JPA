package com.employee.maintain.employee_crud.service;

import com.employee.maintain.employee_crud.error.EmployeeNotFoundException;
import com.employee.maintain.employee_crud.models.Employee;
import org.springframework.stereotype.Service;
import com.employee.maintain.employee_crud.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<Employee>();
    @Override
    public Employee save(Employee e) {

       if(e.getId()==null ||  e.getId().isEmpty()){
           e.setId(UUID.randomUUID().toString());
       }
       employeeList.add(e);
       return e;
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee getById(String id) {
        return employeeList
                .stream()
                .filter(employee -> employee.getId().equalsIgnoreCase(id))
                .findFirst()
                //.orElseThrow(()->new RuntimeException("Employee not found with Id"+id));
                //Create custom exception class and use it to throw relevant exception
                .orElseThrow(()->new EmployeeNotFoundException("Employee not found with Id"+id));
    }

    @Override
    public String delete(String id) {
      Employee employee = employeeList
                .stream()
                .filter(e -> e.getId().equalsIgnoreCase(id))
                .findFirst()
                .get();

      employeeList.remove(employee);
      return "Employee with ID "+id+" successfully deleted";
    }
}
