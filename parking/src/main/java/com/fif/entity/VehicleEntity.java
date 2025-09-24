package com.fif.entity;

import javax.persistence.*;

@Entity
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String vehicleType;
    private  String licensePlate;


    @OneToOne(mappedBy = "vehicle")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "parking_id", referencedColumnName = "id")
    private ParkingEntity parking;

    public VehicleEntity(){

    }


    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setParking(ParkingEntity parking) {
        this.parking = parking;
    }

    public ParkingEntity getParking() {
        return parking;
    }
}
