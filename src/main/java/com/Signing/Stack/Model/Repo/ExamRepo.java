/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.Signing.Stack.Model.Repo;

import com.Signing.Stack.Model.Exam;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SIGNING
 */
public interface ExamRepo extends JpaRepository<Exam, Integer> {
   
}
