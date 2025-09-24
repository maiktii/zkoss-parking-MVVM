package com.fif.vm.employee;

import com.fif.entity.EmployeeEntity;
import com.fif.service.EmployeeService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkplus.spring.SpringUtil;

public class DetailVM {
    private EmployeeService employeeService;
    private EmployeeEntity employee;

    @Init
    public void init() {
        employeeService = (EmployeeService) SpringUtil.getBean("employeeService");

        String empIdStr = Executions.getCurrent().getParameter("empId");
        if (empIdStr != null) {
            Long empId = Long.parseLong(empIdStr);
            employee = employeeService.getEmployeeById(empId);
        }
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }
}
