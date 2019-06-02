/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.services.EnployeeCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class EmployeeCertification {
    @Autowired
    private EnployeeCertificationService enployeeCertificationService;
    
    @GetMapping("/employeecertification")
    public String employeecertification(Model model) {
        model.addAttribute("dataEc", enployeeCertificationService.findAllEmployeeCertification());
        return "employeecertification";
    }
}
