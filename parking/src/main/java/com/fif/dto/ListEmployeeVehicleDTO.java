package com.fif.dto;

import com.fif.entity.VehicleEntity;

public class ListEmployeeVehicleDTO {
    private String employeeName;
    private String employeeNumber;

    private VehicleEntity vehicle;

    public ListEmployeeVehicleDTO(){

    }

    public ListEmployeeVehicleDTO(String employeeName, String employeeNumber, VehicleEntity vehicle){
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.vehicle = vehicle;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }
}
