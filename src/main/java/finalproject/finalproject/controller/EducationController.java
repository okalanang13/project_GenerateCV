/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Education;
import finalproject.finalproject.repositories.CollegeRepository;
import finalproject.finalproject.repositories.DegreeRepository;
import finalproject.finalproject.repositories.EducationRepository;
import finalproject.finalproject.repositories.MajorRepository;
import finalproject.finalproject.services.CollegeService;
import finalproject.finalproject.services.DegreeService;
import finalproject.finalproject.services.EducationService;
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
public class EducationController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private EducationRepository educationRepository;
    
    @Autowired
    private EducationService educationService;
    
    @Autowired
    private CollegeRepository collegeRepository;
    
    @Autowired
    private CollegeService collegeService;
    
    @Autowired
    private MajorRepository majorRepository;
    
    @Autowired
    private MajorService majorService;
    
    @Autowired
    private DegreeRepository degreeRepository;
    
    @Autowired
    private DegreeService degreeService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data
    @GetMapping("/page/education")
    public String education(Model model, Education education) {
        model.addAttribute("dataEducation", educationService.getAllEducation());
        model.addAttribute("dataCollege", collegeService.getAllCollege());
        model.addAttribute("dataMajor", majorService.getAllMajor());
        model.addAttribute("dataDegree", degreeService.getAllDegree());
        return "education";
    }
    
    //fungsi AddData
    @PostMapping("/page/education/addDataEducation")
    public String addDataEducation (@Valid Education education){
        education.setIsDelete("false");
        educationRepository.save(education);
        return "redirect:/page/education";
    }
    
    //proses update data dengan fungsi save dari Crud Repository
    @PostMapping("/page/education/updateDataEducation")
    public String updateDataEducation(@Valid Education education) {
        education.setIsDelete("false");
        educationRepository.save(education);
        return "redirect:/page/education";

    }

    //proses softdelete data dengan fungsi save dari Crud Repository
    @GetMapping("/page/education/softDeleteDataEducation")
    public String softDeleteDataEducation(@Valid Education education) {
        education.setIsDelete("true");
        educationRepository.save(education);
        return "redirect:/page/education";

    }
}
