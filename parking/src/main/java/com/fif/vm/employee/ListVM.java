package com.fif.vm.employee;

import com.fif.entity.EmployeeEntity;
import com.fif.repository.EmployeeInterface;
import com.fif.repository.impl.EmployeeRepository;
import com.fif.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.ListModelList;

import java.util.List;
import java.util.Optional;

@Component
public class ListVM {
    private ListModelList<EmployeeEntity> employees;
    private EmployeeService employeeService;

    @Init
    public void init() {
        // Fetch the bean from Spring
        employeeService = (EmployeeService) SpringUtil.getBean("employeeService");

        List<EmployeeEntity> employeeList = employeeService.getAllEmployeeData();
        employees = new ListModelList<>(employeeList);
    }

    public ListModelList<EmployeeEntity> getEmployees() {
        return employees;
    }

    @Command
    public void viewDetail(@ContextParam(ContextType.TRIGGER_EVENT) org.zkoss.zk.ui.event.Event event,
                           @org.zkoss.bind.annotation.BindingParam("empId") Long empId) {
        Executions.sendRedirect("employeeDetail.zul?empId=" + empId);
    }
}
