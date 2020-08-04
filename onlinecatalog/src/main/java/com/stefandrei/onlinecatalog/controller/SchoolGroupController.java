package com.stefandrei.onlinecatalog.controller;

import com.stefandrei.onlinecatalog.model.Professor;
import com.stefandrei.onlinecatalog.model.SchoolGroup;
import com.stefandrei.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolGroupController {
    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("allschoolgroups")
    public String showAllSchoolGroup(Model model){
        List<SchoolGroup> schoolGroupList = schoolGroupService.findAll();
        model.addAttribute ("schoolgroup" , schoolGroupList);
        return "schoolgroup/showallschoolgroups";
    }

    @GetMapping("/addschoolgroup")
    public String addschoolgroup(Model model){
        model.addAttribute ("schoolgroup" , new SchoolGroup ());

        return "schoolgroup/addschoolgroup";
    }

    @PostMapping("/addschoolgroup")
    public String addschoolgroup(@ModelAttribute SchoolGroup schoolgroup){
        System.out.println (schoolgroup);
        schoolGroupService.save (schoolgroup);

        return "redirect:/allschoolgroups";
    }

    @GetMapping("/editschoolgroup/{id}")
    public String editschoolgroup(Model model , @PathVariable Integer id){
        SchoolGroup schoolGroup = schoolGroupService.findById (id);
        model.addAttribute ("schoolgroup" , schoolGroup);

        return "schoolgroup/editschoolgroup";
    }

    @PostMapping("/editschoolgroup/{id}")
    public String editschoolgroup(@ModelAttribute SchoolGroup schoolGroup , @PathVariable Integer id){
        SchoolGroup database_schoolgroup = schoolGroupService.findById (id);
        database_schoolgroup.setGroupName (schoolGroup.getGroupName ());
        database_schoolgroup.setGroupYear (schoolGroup.getGroupYear ());
        schoolGroupService.save (database_schoolgroup);

        return "redirect:/allprofessors";
    }

    @GetMapping("/deleteschoolgroup/{id}")
    public String deleteprofessor(@PathVariable Integer id){
        schoolGroupService.deleteById(id);

        return "redirect:/allschoolgroup";
    }

}
