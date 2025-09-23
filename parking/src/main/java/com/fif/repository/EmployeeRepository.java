package com.fif.repository;

import com.fif.entity.EmployeeEntity;
import com.fif.entity.VehicleEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements EmployeeInterface{

    static List<EmployeeEntity> employees = new ArrayList<>();
    static {
        employees.add(new EmployeeEntity("EMP001", "John Doe", new VehicleEntity("MOTORCYCLE", "B 1234 XYZ")));
        employees.add(new EmployeeEntity("EMP002", "Jane Smith", new VehicleEntity("CAR", "B 5678 ABC")));
    }

    public List<EmployeeEntity> getAllDataEmployee(){
        return employees;
    }

    public void createEmployeeData (EmployeeEntity employee){
//        if (!employees.isEmpty()){
//            return;
//        }
        employees.add(employee);
    }
}
