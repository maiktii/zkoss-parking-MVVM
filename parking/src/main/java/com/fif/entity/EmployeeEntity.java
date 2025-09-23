package com.fif.entity;

public class EmployeeEntity {
//    private int employeeId;
    private String employeeNumber;

    private String employeeName;

    private  VehicleEntity vehicle;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String employeeNumber, String employeeName, VehicleEntity vehicle){
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.vehicle = vehicle;
    }

    public void setEmployeeNumber(String employeeNumber){
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber(){
        return employeeNumber;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setVehicle(VehicleEntity vehicle){
        this.vehicle = vehicle;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

}
