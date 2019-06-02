/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class SkillController {
    @Autowired
    private SkillService skillService;
    
    @GetMapping("/skill")
    public String skill(Model model) {
        model.addAttribute("dataSkill", skillService.findAllSkill());
        return "skill";
    }
}
