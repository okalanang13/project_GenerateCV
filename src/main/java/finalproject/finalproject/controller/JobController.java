/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Job;
import finalproject.finalproject.entities.Job;
import finalproject.finalproject.repositories.JobRepository;
import finalproject.finalproject.services.JobService;
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
public class JobController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private JobService jobService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/job")
    public String job(Model model) {
        model.addAttribute("dataJob", jobService.findAllJob());
        return "job";
    }
    
    @PostMapping("/page/job/addDataJob")
    public String addDataJob (@Valid Job job){
        jobRepository.save(job);
        return "redirect:/page/job";
    }
}
