/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.ServiceImp;

import com.Signing.Stack.Model.Repo.UserRepo;
import com.Signing.Stack.Model.User;
import com.Signing.Stack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SIGNING
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public User addNewUser(User user) {
        
        return userRepo.save(user);
    }
    
}
