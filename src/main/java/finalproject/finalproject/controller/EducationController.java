/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Education;
import finalproject.finalproject.repositories.EducationRepository;
import finalproject.finalproject.services.EducationService;
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
public class EducationController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private EducationRepository educationRepository;
    
    @Autowired
    private EducationService educationService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/education")
    public String education(Model model) {
        model.addAttribute("dataEducation", educationService.findAllEducation());
        return "education";
    }
    
    @PostMapping("/page/education/addDataEducation")
    public String addDataEducation (@Valid Education education){
        educationRepository.save(education);
        return "redirect:/page/education";
    }
}
