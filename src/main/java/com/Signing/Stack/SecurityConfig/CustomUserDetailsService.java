/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.SecurityConfig;

import com.Signing.Stack.Model.Repo.UserRepo;
import com.Signing.Stack.Model.User;
import com.Signing.Stack.ServiceImp.UserServiceImp;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author SIGNING
 */

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserRepo userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepo.findByEmail(email);
         if (user ==null)
             throw new UsernameNotFoundException("no user found with such name");
         else
             return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
                  
         
    }
    
}
