package com.fif.repository;

import com.fif.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeInterface {
    public List<EmployeeEntity> getAllDataEmployee();
    public void createEmployeeData (EmployeeEntity employee);
}
