package com.fif.service;

import com.fif.dto.RegistrationDTO;
import com.fif.entity.EmployeeEntity;
import com.fif.entity.ParkingEntity;
import com.fif.entity.VehicleEntity;
import com.fif.entity.VehicleTypeEntity;
import com.fif.repository.EmployeeInterface;
import com.fif.repository.VehicleTypeInterface;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Executions;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeInterface employeeInterface;
//    private final VehicleTypeInterface vehicleTypeInterface;
    private final ParkingService parkingService;

//    ParkingEntity defaultParking = new ParkingEntity(
//                "MENARA FIF",
//                100,
//                50,
//                80,
//                40
//    );


    public EmployeeService(EmployeeInterface employeeInterface, ParkingService parkingService){
        this.employeeInterface = employeeInterface;
        this.parkingService = parkingService;
//        this.vehicleTypeInterface = vehicleTypeInterface;
    }

    public List<EmployeeEntity> getAllEmployeeData(){
        return employeeInterface.findAll();
    }

    public void createEmployee(RegistrationDTO dto){

        if (employeeInterface.existsByEmployeeNumber(dto.getEmployeeNumber())) {
            throw new IllegalArgumentException("Employee Number already exists!");
        }

//        VehicleTypeEntity vehicleType = vehicleTypeInterface.findById(dto.getVehicleTypeId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle type"));

        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setVehicleType(dto.getVehicleType().getName());
        vehicle.setLicensePlate(dto.getLicensePlate());

        ParkingEntity parking = parkingService.getParkingById(1L);
        vehicle.setParking(parking);

        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeNumber(dto.getEmployeeNumber());
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setVehicle(vehicle);

        employeeInterface.save(employee);

        // Occupy slot depending on vehicle type
        if ("CAR".equalsIgnoreCase(dto.getVehicleType().getName())) {
            parkingService.occupyCarSpot(parking.getId());
        } else {
            parkingService.occupyMotorSpot(parking.getId());
        }

        Executions.sendRedirect("listEmployee.zul");
    }

    public List<EmployeeEntity> getRecentEmployees(int limit) {
        List<EmployeeEntity> all = employeeInterface.findAll(
                org.springframework.data.domain.Sort.by("id").descending()
        );
        return all.stream().limit(limit).toList();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeInterface.findById(id).orElse(null);
    }
}
