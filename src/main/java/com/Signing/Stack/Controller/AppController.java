/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Controller;

import com.Signing.Stack.Model.LoginModel;
import com.Signing.Stack.Model.Paper;
import com.Signing.Stack.Model.Repo.PaperRepo;
import com.Signing.Stack.Model.Repo.RoleRepo;
import com.Signing.Stack.Model.Repo.UserRepo;
import com.Signing.Stack.Model.Role;
import com.Signing.Stack.Model.User;
import com.Signing.Stack.ServiceImp.UserServiceImp;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SIGNING
 */
@Controller
@RequestMapping("/api")
public class AppController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RoleRepo roleRepo;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private UserServiceImp userServiceImp;
    
    @Autowired
    private PaperRepo paperRepo;
    
    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("LoginModel", new LoginModel());
        
        return "login.html";
    }
    
    @GetMapping("/register")
    public String registerUser(Model model){
        
        model.addAttribute("user", new User());
        return "userForm";
    }
    
    
    @PostMapping("/register")
   public String register(@ModelAttribute User user,HttpSession session) throws Exception
   {    
       if (userRepo.findByEmail(user.getEmail()) ==null) {
           
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       
       Set<Role> roles = new HashSet<>();
       User NUser = userServiceImp.addNewUser(user);
       roleRepo.save(new Role(null,"USER",NUser));
        session.setAttribute("user", userRepo.findByEmail(user.getEmail()));
        return "redirect:/api/login";
       }
       else
           throw new Exception("Email address already used");
   }
   
   @PostMapping("/authenticate")
   public String login(@ModelAttribute LoginModel model,HttpSession session,Model models) throws Exception
   {      
       Authentication auth;
       try {
           auth = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(model.getEmail(), model.getPassword()));
           SecurityContextHolder.getContext().setAuthentication(auth);
           
           session.setAttribute("user", userRepo.findByEmail(auth.getName()));
           
//           Paper paper= (Paper) paperRepo.findAll();
//           models.addAttribute("papers", paper);
                     
           
       } catch (Exception e) {
           
           if (e.getMessage().equals("no user with such username exist"))
           {
               models.addAttribute("message", "Unknown email address please verify it and try again!");
               models.addAttribute("LoginModel", new LoginModel());
        
               return "login";
           }
           else if(e.getMessage().equals("invalid password"))
           {
               models.addAttribute("message", e.getMessage());
               models.addAttribute("LoginModel", new LoginModel());
        
               return "login";
           }
          
       } 
       return "index";
   }
  
}