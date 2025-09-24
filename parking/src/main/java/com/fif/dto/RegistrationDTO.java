package com.fif.dto;

public class RegistrationDTO {
    private String employeeName;
    private String employeeNumber;

    private String vehicleType;
    private String licensePlate;

    public RegistrationDTO(){

    }

    public RegistrationDTO(String employeeName, String employeeNumber, String vehicleType, String licensePlate){
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
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

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
