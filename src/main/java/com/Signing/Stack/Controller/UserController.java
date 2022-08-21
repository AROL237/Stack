/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Signing.Stack.Controller;

import com.Signing.Stack.Model.Exam;
import com.Signing.Stack.Model.Options;
import com.Signing.Stack.Model.Paper;
import com.Signing.Stack.Model.Repo.ExamRepo;
import com.Signing.Stack.Model.Repo.OptionRepo;
import com.Signing.Stack.Model.Repo.PaperRepo;
import com.Signing.Stack.Model.Repo.SpecialtyRepo;
import com.Signing.Stack.Model.Specialty;
import com.Signing.Stack.Model.User;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author SIGNING
 */
@Controller
@RequestMapping("/user")

public class UserController {
    
    @Autowired
    private PaperRepo paperRepo;
    
    @Autowired
    private ExamRepo examRepo;
    
    @Autowired
    private OptionRepo optionRepo;
    
    @Autowired
    private SpecialtyRepo specialtyRepo;
    
    @GetMapping("/index")
    public String index(HttpSession session, Model model){
        
        session.setAttribute("user", session.getAttribute("user"));
        
        return "index";
    }
    
    @GetMapping("/adminpage")
    public String index(Model model,HttpSession session)
    {
        session.setAttribute("user", session.getAttribute("user"));
        
        return "adminpage";
    }
    
     @GetMapping("/AdminOperations")
   public String AdminOperations(HttpServletResponse response,Model model)
   {
       model.addAttribute("specialties", specialtyRepo.findAll());
//       model.addAttribute("options", examRepo.findById(1).stream().map((exam) -> {
//           return exam.getOptionsSet(); 
//       }));

    model.addAttribute("options", optionRepo.findAll());
    model.addAttribute("paper",new Paper());
      
       return "questionPaper"; 
   }

   public  String addNewQuestioniPaper(@RequestBody Paper paper, Model model){




        return null;
   }
    
    
    @GetMapping("/dashboard")
    public String dashboard()
    {
        return "welcome to dashboard controller end point";
    }
}
