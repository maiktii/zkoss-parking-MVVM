package com.fif.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking")
public class ParkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private int carCapacity;
    private int motorCapacity;
    private int availCarSpot;
    private int availMotorSpot;

    @OneToMany(mappedBy = "parking")
    private List<VehicleEntity> vehicle;

    public ParkingEntity(){

    }

    public ParkingEntity(String address, int carCapacity, int motorCapacity, int availCarSpot, int availMotorSpot){
//        this.parkingId = parkingId;
        this.address = address;
        this.carCapacity = carCapacity;
        this.motorCapacity = motorCapacity;
        this.availCarSpot = availCarSpot;
        this.availMotorSpot = availMotorSpot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setMotorCapacity(int motorCapacity) {
        this.motorCapacity = motorCapacity;
    }

    public int getMotorCapacity() {
        return motorCapacity;
    }

    public void setAvailCarSpot(int availCarSpot) {
        this.availCarSpot = availCarSpot;
    }

    public int getAvailCarSpot() {
        return availCarSpot;
    }

    public void setAvailMotorSpot(int availMotorSpot) {
        this.availMotorSpot = availMotorSpot;
    }

    public int getAvailMotorSpot() {
        return availMotorSpot;
    }
}

