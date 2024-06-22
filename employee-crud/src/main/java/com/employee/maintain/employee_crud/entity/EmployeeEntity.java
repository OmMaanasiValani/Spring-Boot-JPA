package com.employee.maintain.employee_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {

    @Id
    public String id;
    public String name;
    public String emailId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
