/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.Signing.Stack.Model.Repo;

import com.Signing.Stack.Model.Options;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author SIGNING
 */
public interface OptionRepo extends CrudRepository<Options, Integer> {
    
}
