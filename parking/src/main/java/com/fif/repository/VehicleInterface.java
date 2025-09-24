package com.fif.repository;

import com.fif.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleInterface extends JpaRepository<VehicleEntity, Long> {
}
