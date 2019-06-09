/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.College;
import finalproject.finalproject.repositories.CollegeRepository;
import finalproject.finalproject.repositories.VillageRepository;
import finalproject.finalproject.services.CollegeService;
import finalproject.finalproject.services.VillageService;
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
    
    @Autowired
    private VillageRepository villageRepository;
    
    @Autowired
    private VillageService villageService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/college")
    public String college(Model model, College college) {
        model.addAttribute("dataCollege", collegeService.getAllCollege());
        model.addAttribute("dataVillage", villageService.getAllVillage());
        return "college";
    }
    
    //proses tambah data dengan fungsi save dari Crud Repository
    @PostMapping("/page/college/addDataCollege")
    public String addDataCollege (@Valid College college){
        college.setIsDelete("false");
        collegeRepository.save(college);
        return "redirect:/page/college";
    }
    
    //proses update data dengan fungsi save dari Crud Repository
    @PostMapping("/page/college/updateDataCollege")
    public String updateDataCollege(@Valid College college) {
        college.setIsDelete("false");
        collegeRepository.save(college);
        return "redirect:/page/college";

    }

    //proses softdelete data dengan fungsi save dari Crud Repository
    @GetMapping("/page/college/softDeleteDataCollege")
    public String softDeleteDataCollege(@Valid College college) {
        college.setIsDelete("true");
        collegeRepository.save(college);
        return "redirect:/page/college";

    }

}
