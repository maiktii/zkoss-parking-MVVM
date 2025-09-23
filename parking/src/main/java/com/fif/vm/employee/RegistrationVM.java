package com.fif.vm.employee;

import com.fif.entity.EmployeeEntity;
import com.fif.entity.VehicleEntity;
import com.fif.repository.EmployeeRepository;
import com.fif.service.EmployeeService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class RegistrationVM {

    private EmployeeEntity employee = new EmployeeEntity();
    private VehicleEntity vehicle = new VehicleEntity();

    private EmployeeService employeeService;

    public RegistrationVM() {
        employeeService = new EmployeeService(new EmployeeRepository());
        employee.setVehicle(vehicle); // link vehicle to employee
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    // Command triggered by button
    @Command
    @NotifyChange("employee")
    public void addEmployee() {
        employeeService.createEmployee(employee);

        // reset
        employee = new EmployeeEntity();
        employee.setVehicle(new VehicleEntity());
    }
}
