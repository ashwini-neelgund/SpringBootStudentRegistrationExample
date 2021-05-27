package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Student;
import org.perscholas.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("create")
@SessionAttributes({"student"})
@Log
public class HomeController {

    StudentServices studentServices;

    @Autowired
    public HomeController(StudentServices studentServices){
        this.studentServices = studentServices;
    }

    @GetMapping("/form")
    public String form(){
        return "registerstudent";
    }

    @GetMapping("/studentInfo")
    public String studentInfo(){
        return "studentinfo";
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
    public String newStudent(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model){
        if(result.hasErrors()) {
            System.out.println(String.valueOf(result.getErrorCount()));
            return "registerstudent";
        }else{
            log.info("Student : "+student);
            Student persistedStudent = studentServices.saveStudent(student);
            if(persistedStudent != null) {
                model.addAttribute("student", persistedStudent);
                return "student_confirmation";
            }else {
                model.addAttribute("errormessage", "Student is already registered. Please Login.");
                return "index";
            }
        }
    }

    @GetMapping("getsession")
    public String getSession(){
        return "getsession";
    }

    @GetMapping("showstudent/{id}")
    public String showStudent(@PathVariable("id") Long studentId, Model model){
        Student s = studentServices.getStudentById(studentId);
        model.addAttribute("student", s);
        return "showstudent";
    }

}
