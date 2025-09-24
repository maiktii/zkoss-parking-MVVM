package com.fif.service;

import com.fif.entity.ParkingEntity;
import com.fif.repository.ParkingInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private ParkingInterface parkingRepository;

    public ParkingService(ParkingInterface parkingRepository){
        this.parkingRepository = parkingRepository;
    }


    public ParkingEntity getDefaultParking() {
        return parkingRepository.findById(1L).orElse(null);
    }

    public List<ParkingEntity> getAllParkings() {
        return parkingRepository.findAll();
    }

    public ParkingEntity saveParking(ParkingEntity parking) {
        return parkingRepository.save(parking);
    }

    public ParkingEntity getParkingById(Long id) {
        return parkingRepository.findById(id).orElse(null);
    }

    public void occupyCarSpot(Long parkingId) {
        ParkingEntity parking = getParkingById(parkingId);
        if (parking != null && parking.getAvailCarSpot() > 0) {
            parking.setAvailCarSpot(parking.getAvailCarSpot() - 1);
            parkingRepository.save(parking);
        }
    }

    public void occupyMotorSpot(Long parkingId) {
        ParkingEntity parking = getParkingById(parkingId);
        if (parking != null && parking.getAvailMotorSpot() > 0) {
            parking.setAvailMotorSpot(parking.getAvailMotorSpot() - 1);
            parkingRepository.save(parking);
        }
    }

    public int getAvailableSlots() {
        return parkingRepository.findAll()
                .stream()
                .mapToInt(p -> p.getAvailCarSpot() + p.getAvailMotorSpot())
                .sum();
    }
}
