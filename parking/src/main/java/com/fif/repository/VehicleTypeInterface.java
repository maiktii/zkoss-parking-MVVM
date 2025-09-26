package com.fif.repository;

import com.fif.entity.VehicleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeInterface extends JpaRepository<VehicleTypeEntity, Long> {
}
