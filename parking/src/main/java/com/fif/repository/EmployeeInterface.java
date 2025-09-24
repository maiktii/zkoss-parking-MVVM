package com.fif.repository;

import com.fif.dto.RegistrationDTO;
import com.fif.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeInterface extends JpaRepository<EmployeeEntity, Long>  {
    Optional<EmployeeEntity> findByEmployeeNumber(String employeeNumber);
    boolean existsByEmployeeNumber(String employeeNumber);
}
