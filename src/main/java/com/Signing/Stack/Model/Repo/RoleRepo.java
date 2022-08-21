/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.Signing.Stack.Model.Repo;

import com.Signing.Stack.Model.Role;
import com.Signing.Stack.Model.User;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SIGNING
 */
public interface RoleRepo extends JpaRepository<Role, Integer> {
    
}
