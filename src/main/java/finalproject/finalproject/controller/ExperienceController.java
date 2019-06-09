/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Experience;
import finalproject.finalproject.repositories.ExperienceRepository;
import finalproject.finalproject.services.ExperienceService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author RR17
 */
@Controller
public class ExperienceController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private ExperienceRepository experienceRepository;
    
    @Autowired
    private ExperienceService experienceService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/experience")
    public String experience(Model model) {
        model.addAttribute("dataExperience", experienceService.getAllExperience());
        return "experience";
    }
    
    @PostMapping("/page/experience/addDataExperience")
    public String addDataExperience (@Valid Experience experience){
        experienceRepository.save(experience);
        return "redirect:/page/experience";
    }
}
