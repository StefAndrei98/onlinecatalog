package com.stefandrei.onlinecatalog.controller;

import com.stefandrei.onlinecatalog.model.Professor;
import com.stefandrei.onlinecatalog.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("allprofessors")
    public String showAllProfessors(Model model){

        List<Professor> professorList = professorService.findAll ();
        model.addAttribute ("professors" , professorList);

        return "professor/showallprofessors";
    }
}
