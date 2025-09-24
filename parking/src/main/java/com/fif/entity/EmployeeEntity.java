package com.fif.entity;

import javax.persistence.*;

@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    private int employeeId;
    private String employeeNumber;

    private String employeeName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private VehicleEntity vehicle;

    public EmployeeEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
