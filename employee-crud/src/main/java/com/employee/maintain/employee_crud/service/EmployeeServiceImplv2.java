package com.employee.maintain.employee_crud.service;

import com.employee.maintain.employee_crud.entity.EmployeeEntity;
import com.employee.maintain.employee_crud.models.Employee;
import com.employee.maintain.employee_crud.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplv2 implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepo;
    @Override
    public Employee save(Employee e) {
        if(e.getId()==null ||  e.getId().isEmpty()){
            e.setId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(e,employeeEntity);
        employeeRepo.save(employeeEntity);
        return e;
    }

    @Override
    public List<Employee> getAll() {
        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
        List<Employee> employeeList = employeeEntityList
                .stream().map(employeeEntity -> {
                    Employee e = new Employee();
                    BeanUtils.copyProperties(employeeEntity,e);
                    return e;
                }).collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Employee getById(String id) {
        EmployeeEntity employeeEntity = employeeRepo.getById(id);
        Employee e =new Employee();
        BeanUtils.copyProperties(employeeEntity,e);
        return e;
    }

    @Override
    public String delete(String id) {
        employeeRepo.deleteById(id);
        return "Employee successfully deleted with Id "+id;
    }
}
