/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Major;
import finalproject.finalproject.repositories.MajorRepository;
import finalproject.finalproject.services.MajorService;
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
public class MajorController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private MajorRepository majorRepository;
    
    @Autowired
    private MajorService majorService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/major")
    public String major(Model model) {
        model.addAttribute("dataMajor", majorService.findAllMajor());
        return "major";
    }
    
    @PostMapping("/page/major/addDataMajor")
    public String addDataMajor (@Valid Major major){
        majorRepository.save(major);
        return "redirect:/page/major";
    }
}
