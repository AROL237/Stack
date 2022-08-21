/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.SecurityConfig;

import com.Signing.Stack.Model.Repo.RoleRepo;
import com.Signing.Stack.Model.Repo.UserRepo;
import com.Signing.Stack.Model.Role;
import com.Signing.Stack.Model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author SIGNING
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private  UserRepo userRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;
        @Autowired
        private RoleRepo roleRepo;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        User user  = userRepo.findByEmail(email);
        
        if (user ==null)
            throw new UsernameNotFoundException("no user with such username exist");
        if (passwordEncoder.matches(password, user.getPassword()))
        {
            ArrayList<GrantedAuthority> authority = new ArrayList<>();
            user.getRoleSet().forEach(role->
            {
                authority.add(new SimpleGrantedAuthority(role.getRole()));
            });
            
            return new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword(),authority);
        }
        else
            throw new BadCredentialsException("invalid password");
    }

//    public Set<GrantedAuthority> getAuthotity(User user){
//        
//        user.getRoleSet().forEach(role->{
//            System.out.println(role.getRole());
//        });
//        
//        Set<GrantedAuthority> authority = null;
//        
//        user.getRoleSet().forEach((role) -> {
//            authority.add(new SimpleGrantedAuthority(role.getRole()));
//        });
////        for (GrantedAuthority grantedAuthority : authority) {
////            System.out.println(grantedAuthority.getAuthority());
////            
////        }
//               return authority;
//    }
    
    
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
}
