package com.fif.vm.employee;

import com.fif.entity.EmployeeEntity;
import com.fif.repository.EmployeeRepository;
import com.fif.service.EmployeeService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import java.util.List;

public class ListVM {
    private ListModelList<EmployeeEntity> employees;
    private EmployeeService employeeService;

    @Init
    public void init() {
        employeeService = new EmployeeService(new EmployeeRepository());

        List<EmployeeEntity> employeeList = employeeService.getAllEmployeeData();
        employees = new ListModelList<>(employeeList);
    }

    public ListModelList<EmployeeEntity> getEmployees() {
        return employees;
    }
}
