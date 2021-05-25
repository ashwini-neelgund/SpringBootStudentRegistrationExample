package org.perscholas.controllers;

import org.perscholas.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("create")
@SessionAttributes("student")
public class HomeController {

    @GetMapping("/form")
    public String form(){
        return "registerstudent";
    }

//    @PostMapping("/newstudent")
//    public String newStudent(@RequestParam("username") String username,
//                             @RequestParam("email") String email,
//                             @RequestParam("password") String password,
//                             Model model){
//
//        Student student = new Student();
//        student.setSUserName(username);
//        student.setSEmail(email);
//        student.setSPassword(password);
//        model.addAttribute("student",student);
//        return "student_confirmation";
//    }

    @ModelAttribute("student")
    public Student initStudent(){
        return new Student();
    }

    @PostMapping("/newstudent")
    public String newStudent(@ModelAttribute("student") @Valid Student student,BindingResult result, Model model){
        if(result.hasErrors()) {
            System.out.println(String.valueOf(result.getErrorCount()));
            return "registerstudent";
        }else{
            model.addAttribute("student", student);
            return "student_confirmation";
        }
    }

    @GetMapping("getsession")
    public String getSession(){

        return "getsession";
    }

}
