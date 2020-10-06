package com.stefandrei.forumproject.controller;

import com.stefandrei.forumproject.model.Topic;
import com.stefandrei.forumproject.service.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TopicController {

    @Autowired
    private TopicServices topicServices;


//
//    @Autowired
////    private SchoolGroupService schoolGroupService;
//
    @GetMapping("/showtopic")
    public String showTopics(Model model){

        List<Topic> topicList = topicServices.findAll ();
        model.addAttribute ("topic" , topicList);

        return "topiccontent/showtopic";
    }


    @GetMapping("/onlytitle")
    public String onlyTitle(Model model){

        List<Topic> topicList = topicServices.findAll ();
        model.addAttribute ("topic" , topicList);

        return "topiccontent/onlytitle";
    }


    @GetMapping("/actiontopic")
    public String actiontopic(Model model){

        model.addAttribute ("topic" , new Topic ());
//        model.addAttribute ("schoolgroups" , schoolGroupService.findAll ());

        return "topiccontent/actiontopic";
    }

    @PostMapping("/actiontopic")
    public String actiontopic(@ModelAttribute Topic topic){
        System.out.println (topic);
        topicServices.save (topic);

        return "redirect:/showtopic";
    }
//
//    @GetMapping("/editstudent/{id}")
//    public String editstudent(Model model , @PathVariable Integer id){
//        Student student = studentService.findById (id);
//        model.addAttribute ("student" , student);
//        model.addAttribute ("schoolgroups" , schoolGroupService.findAll ());
//
//        return "student/editstudent";
//    }
//
//    @PostMapping("/editstudent/{id}")
//    public String editstudent(@ModelAttribute Student student , @PathVariable Integer id){
//
////        Student database_student = studentService.findById (id); // to be able to update that id, get it from database
////        database_student.setFirstName (student.getFirstName ()); // update fields
////        database_student.setLastName (student.getLastName ());
////        studentService.save (database_student);
//        studentService.save (student);
//
//
//        return "redirect:/allstudents";
//    }
//

    @GetMapping("/deletetopic/{id}")
    public String deletetopic(@PathVariable Integer id){
        topicServices.deleteById(id);
        // Student student = studentRepository.findById (id).get ();
        // studentRepository.delete(student);

        return "redirect:/showtopic";
    }
}
