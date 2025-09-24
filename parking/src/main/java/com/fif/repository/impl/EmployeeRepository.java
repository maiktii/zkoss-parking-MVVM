package com.fif.repository.impl;

import com.fif.dto.RegistrationDTO;
import com.fif.entity.EmployeeEntity;
import com.fif.entity.VehicleEntity;
import com.fif.repository.EmployeeInterface;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static List<EmployeeEntity> employees = new ArrayList<>();

    public void save(EmployeeEntity employee) {
        employees.add(employee);
    }

    public List<EmployeeEntity> findAll() {
        return employees;
    }
}
