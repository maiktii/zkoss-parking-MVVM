package com.fif.vm.employee;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;


public class LoginVM {

    private AuthenticationManager authenticationManager;

    private String username;
    private String password;
    private String errorMessage;


    // Getter & Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    @Command
    @NotifyChange("errorMessage")
    public void doLogin() {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            Executions.sendRedirect("/index.zul");
        } catch (AuthenticationException e) {
            errorMessage = "Invalid username or password!";
        }
    }

    @Command
    public void goToRegister() {
        Executions.sendRedirect("/pages/register.zul");
    }
}
