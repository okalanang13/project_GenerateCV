/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Degree;
import finalproject.finalproject.repositories.DegreeRepository;
import finalproject.finalproject.services.DegreeService;
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
public class DegreeController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private DegreeRepository degreeRepository;
    
    @Autowired
    private DegreeService degreeService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/degree")
    public String degree(Model model) {
        model.addAttribute("dataDegree", degreeService.findAllDegree());
        return "degree";
    }
    
    @PostMapping("/page/degree/addDataDegree")
    public String addDataDegree (@Valid Degree degree){
        degreeRepository.save(degree);
        return "redirect:/page/degree";
    }
}
