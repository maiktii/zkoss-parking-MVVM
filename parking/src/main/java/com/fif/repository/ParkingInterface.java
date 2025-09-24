package com.fif.repository;

import com.fif.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ParkingInterface extends JpaRepository<ParkingEntity, Long> {
//    public List<ParkingEntity> getParkingData();
//    public void createParking(ParkingRecord parking);
}
