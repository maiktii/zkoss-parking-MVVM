package com.fif.vm.employee;

import com.fif.entity.AuthEntity;
import com.fif.entity.EmployeeEntity;
import com.fif.repository.AuthInterface;
import com.fif.service.EmployeeService;
import com.fif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class RegisterVM {
    @WireVariable
    private UserService userService; // use service layer

    @WireVariable
    private PasswordEncoder passwordEncoder;

    @Init
    public void init() {
        // Fetch the bean from Spring
        userService = (UserService) SpringUtil.getBean("userService");

        passwordEncoder = (PasswordEncoder) SpringUtil.getBean("passwordEncoder");
    }

    private String username;
    private String password;
    private String confirmPassword;
    private String errorMessage;

    // Getter & Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    @Command
    @NotifyChange("errorMessage")
    public void doRegister() {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            errorMessage = "Username and password cannot be empty";
            return;
        }

        if(!password.equals(confirmPassword)){
            errorMessage = "Password and Confirm Password do not match!";
            return;
        }

        if(userService.get(username) != null){
            errorMessage = "Username already exists!";
            return;
        }

        AuthEntity newUser = new AuthEntity();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRole("ROLE_USER");

        userService.saveUser(newUser);

        Executions.sendRedirect("/pages/login.zul");
    }
}
