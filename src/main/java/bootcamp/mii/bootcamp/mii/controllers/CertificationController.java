/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Certification;
import bootcamp.mii.bootcamp.mii.repositories.CertificationRepository;
import bootcamp.mii.bootcamp.mii.services.CertificationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class CertificationController {
    @Autowired
    private CertificationService certificationService;

    @Autowired
    private CertificationRepository certificationRepository;

    @GetMapping("/certification")
    public String certification(Model model) {
        model.addAttribute("dataCertification", certificationService.findAllCertification());
        return "certification";
    }

    @PostMapping("/addcertification")

    public String addcertification(@Valid Certification c) {
        c.setId(0);
        c.setIsDelete('0');
        certificationRepository.save(c);
        return "redirect:/certification";

    }

    @PostMapping("/updatecertification")

    public String updatecertification(@Valid Certification c) {
        c.setIsDelete('0');
        certificationRepository.save(c);
        return "redirect:/certification";

    }
    
    @GetMapping("/deletecertification")

    public String deletecertification(@Valid Certification c) {
        c.setIsDelete('1');
        certificationRepository.save(c);
        return "redirect:/certification";

    }
}
