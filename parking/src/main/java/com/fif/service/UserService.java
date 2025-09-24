package com.fif.service;

import com.fif.entity.AuthEntity;
import com.fif.repository.AuthInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthInterface authRepo;

    public AuthEntity get(String name){
        return authRepo.findByUsername(name).orElse(null);
    }

    public void saveUser(AuthEntity request){
        authRepo.save(request);
    }

}
