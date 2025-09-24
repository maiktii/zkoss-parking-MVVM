package com.fif.vm.employee;

import com.fif.entity.EmployeeEntity;
import com.fif.service.EmployeeService;
import com.fif.service.ParkingService;
import com.fif.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zkplus.spring.SpringUtil;

import java.util.List;

@Component
public class DashboardVM {
    private EmployeeService employeeService;

    private VehicleService vehicleService;

    private ParkingService parkingService;

    private int totalEmployees;
    private int totalVehicles;
    private int availableParking;
    private List<EmployeeEntity> recentEmployees;

    @Init
    public void init() {
        employeeService = (EmployeeService)  SpringUtil.getBean("employeeService");
        vehicleService = (VehicleService) SpringUtil.getBean("vehicleService");
        parkingService = (ParkingService) SpringUtil.getBean("parkingService");

        totalEmployees = employeeService.getAllEmployeeData().size();
        totalVehicles = vehicleService.getAllVehicles().size();
        availableParking = parkingService.getAvailableSlots();
        recentEmployees = employeeService.getRecentEmployees(5); // last 5 employees
    }

    // Getters for ZUL binding
    public int getTotalEmployees() { return totalEmployees; }
    public int getTotalVehicles() { return totalVehicles; }
    public int getAvailableParking() { return availableParking; }
    public List<EmployeeEntity> getRecentEmployees() { return recentEmployees; }
}
