package com.fif.service;

import com.fif.entity.VehicleEntity;
import com.fif.entity.VehicleTypeEntity;
import com.fif.repository.VehicleInterface;
import com.fif.repository.VehicleTypeInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleInterface vehicleRepository;
    private final VehicleTypeInterface vehicleTypeInterface;

    public VehicleService(VehicleInterface vehicleRepository, VehicleTypeInterface vehicleTypeInterface) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeInterface = vehicleTypeInterface;
    }

    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public VehicleEntity saveVehicle(VehicleEntity vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public List<VehicleTypeEntity> getVehicleType(){
        return vehicleTypeInterface.findAll();
    }
}
