package com.fif.vm.employee;

import com.fif.dto.RegistrationDTO;
import com.fif.entity.EmployeeEntity;
import com.fif.entity.VehicleEntity;
import com.fif.entity.VehicleTypeEntity;
import com.fif.repository.EmployeeInterface;
import com.fif.repository.impl.EmployeeRepository;
import com.fif.service.EmployeeService;
import com.fif.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import java.util.List;

@Component
public class RegistrationVM {

    private RegistrationDTO requestCreate;

    private EmployeeService employeeService;
    private VehicleService vehicleService;
//    private List<String> vehicleTypes;

//    public RegistrationVM(){
//
//    }

    @Init
    public void init() {
        employeeService = (EmployeeService) SpringUtil.getBean("employeeService");
        vehicleService = (VehicleService) SpringUtil.getBean("vehicleService");
        requestCreate = new RegistrationDTO(); // 🔥 initialize here
//        vehicleTypes = List.of("CAR", "MOTORCYCLE");
    }

    public RegistrationDTO getRequestCreate() {
        return requestCreate;
    }

    public void setRequestCreate(RegistrationDTO requestCreate) {
        this.requestCreate = requestCreate;
    }

    public List<VehicleTypeEntity> getVehicleTypes() {
        return vehicleService.getVehicleType();
    }

    @Command
    @NotifyChange("requestCreate")
    public void addEmployee() {
        try {
            employeeService.createEmployee(requestCreate);
            requestCreate = new RegistrationDTO();
        } catch (IllegalArgumentException e) {
            Messagebox.show(e.getMessage(), "Error", Messagebox.OK, Messagebox.ERROR);
        }
    }
}
