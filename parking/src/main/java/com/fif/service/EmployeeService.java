package com.fif.service;

import com.fif.entity.EmployeeEntity;
import com.fif.repository.EmployeeInterface;
import org.zkoss.zk.ui.Executions;

import java.util.List;

public class EmployeeService {

    private final EmployeeInterface employeeInterface;

    public EmployeeService(EmployeeInterface employeeInterface){
        this.employeeInterface = employeeInterface;
    }

    public void createEmployee(EmployeeEntity employee){
        employeeInterface.createEmployeeData(employee);
        Executions.sendRedirect("listEmployee.zul");
    }

    public List<EmployeeEntity> getAllEmployeeData(){
        return employeeInterface.getAllDataEmployee();
    }
}
