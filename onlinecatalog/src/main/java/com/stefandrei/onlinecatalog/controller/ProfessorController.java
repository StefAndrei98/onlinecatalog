package com.stefandrei.onlinecatalog.controller;

import com.stefandrei.onlinecatalog.model.Professor;
import com.stefandrei.onlinecatalog.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("allprofessors")
    public String showAllProfessors(Model model) {

        List<Professor> professorList = professorService.findAll ();
        model.addAttribute ("professors", professorList);

        return "professor/showallprofessors";
    }

    @GetMapping("/addprofessor")
    public String addprofessor(Model model){
        model.addAttribute ("professor" , new Professor ());

        return "professor/addprofessor";
    }

    @PostMapping("/addprofessor")
    public String addprofessor(@ModelAttribute Professor professor){
        System.out.println (professor);
        professorService.save (professor);

        return "redirect:/allprofessors";
    }

    @GetMapping("/editprofessor/{id}")
    public String editprofessor(Model model , @PathVariable Integer id){
        Professor professor = professorService.findById (id);
        model.addAttribute ("professor" , professor);

        return "professor/editprofessor";
    }

    @PostMapping("/editprofessor/{id}")
    public String editprofessor(@ModelAttribute Professor professor , @PathVariable Integer id){
        Professor database_professor = professorService.findById (id);
        database_professor.setProfessorFirstName (professor.getProfessorFirstName ());
        database_professor.setProfessorLastName (professor.getProfessorLastName ());
        professorService.save (database_professor);

        return "redirect:/allprofessors";
    }

    @GetMapping("/deleteprofessor/{id}")
    public String deleteprofessor(@PathVariable Integer id){
        professorService.deleteById(id);

        return "redirect:/allprofessors";
    }


}
