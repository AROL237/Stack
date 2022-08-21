/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.Signing.Stack.Model.Repo;

import com.Signing.Stack.Model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SIGNING
 */
public interface SpecialtyRepo extends JpaRepository<Specialty, Integer> {
    
}
