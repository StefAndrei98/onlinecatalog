package com.stefandrei.onlinecatalog.controller;

import com.stefandrei.onlinecatalog.model.Student;
import com.stefandrei.onlinecatalog.repository.StudentRepository;
import com.stefandrei.onlinecatalog.service.StudentService;
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
   // private StudentRepository studentRepository;
    private StudentService studentService;

    @GetMapping("allstudents")
    public String showAllStudents(Model model){

        List<Student> studentList = studentService.findAll ();
        model.addAttribute ("students" , studentList);

        return "student/showallstudents";
    }

    @GetMapping("/addstudent")
    public String addstudent(Model model){
        model.addAttribute ("student" , new Student ());

        return "student/addstudent";
    }

    @PostMapping("/addstudent")
    public String addstudent(@ModelAttribute Student student){
        System.out.println (student);
        studentService.save (student);

        return "redirect:/allstudents";
    }

    @GetMapping("/editstudent/{id}")
    public String editstudent(Model model , @PathVariable Integer id){
        Student student = studentService.findById (id);
        model.addAttribute ("student" , student);

        return "student/editstudent";
    }

    @PostMapping("/editstudent/{id}")
    public String editstudent(@ModelAttribute Student student , @PathVariable Integer id){
        Student database_student = studentService.findById (id);
        database_student.setFirstName (student.getFirstName ());
        database_student.setLastName (student.getLastName ());
        //System.out.println (database_student);
        studentService.save (database_student);

        return "redirect:/allstudents";
    }

    @GetMapping("/deletestudent/{id}")
    public String deletestudent(@PathVariable Integer id){
        studentService.deleteById(id);
        // Student student = studentRepository.findById (id).get ();
       // studentRepository.delete(student);

        return "redirect:/allstudents";
    }


}
