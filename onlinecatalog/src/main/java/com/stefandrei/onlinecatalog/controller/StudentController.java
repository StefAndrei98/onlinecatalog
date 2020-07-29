package com.stefandrei.onlinecatalog.controller;

import com.stefandrei.onlinecatalog.model.Student;
import com.stefandrei.onlinecatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("allstudents")
    public String showAllStudents(Model model){

        List<Student> studentList = studentRepository.findAll ();
        model.addAttribute ("students" , studentList);

        return "showallstudents";
    }

    @GetMapping("/")
    public String index(){


        return "index";
    }

    @GetMapping("/addstudent")
    public String addstudent(Model model){
        model.addAttribute ("student" , new Student ());

        return "addstudent";
    }

    @PostMapping("/addstudent")
    public String addstudent(@ModelAttribute Student student){
        System.out.println (student);
        studentRepository.save (student);

        return "redirect:/allstudents";
    }

    @GetMapping("/editstudent/{id}")
    public String editstudent(Model model , @PathVariable Integer id){
        Student student = studentRepository.findById (id).get ();
        model.addAttribute ("student" , student);

        return "editstudent";
    }

    @PostMapping("/editstudent{id}")
    public String editstudent(@ModelAttribute Student student , @PathVariable Integer id){
        Student database_student = studentRepository.findById (id).get ();
        database_student.setFirstName (student.getFirstName ());
        database_student.setLastName (student.getLastName ());
        //System.out.println (database_student);
        studentRepository.save (database_student);

        return "redirect:/allstudents";
    }

}
