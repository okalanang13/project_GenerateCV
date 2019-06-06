/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.College;
import finalproject.finalproject.repositories.CollegeRepository;
import finalproject.finalproject.services.CollegeService;
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
public class CollegeController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private CollegeRepository collegeRepository;
    
    @Autowired
    private CollegeService collegeService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/college")
    public String college(Model model) {
        model.addAttribute("dataCollege", collegeService.findAllCollege());
        return "college";
    }
    
    //proses tambah data dengan fungsi save dari Crud Repository
    @PostMapping("/page/college/addDataCollege")
    public String addDataCollege (@Valid College college){
        collegeRepository.save(college);
        return "redirect:/page/college";
    }
}
