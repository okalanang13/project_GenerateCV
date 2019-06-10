/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Skill;
import bootcamp.mii.bootcamp.mii.repositories.SkillRepository;
import bootcamp.mii.bootcamp.mii.services.CategoryService;
import bootcamp.mii.bootcamp.mii.services.SkillService;
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
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private CategoryService categoryservice;
    
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/skill")
    public String skill(Model model) {
        model.addAttribute("dataSkill", skillService.findAllSkill());
        model.addAttribute("dataCategory", categoryservice.findAllCategory());
        return "skill";
    }

    @PostMapping("/addskill")

    public String addskill(@Valid Skill skill) {
        skill.setId(0);
        skill.setIsDelete('0');
        skillRepository.save(skill);
        return "redirect:/skill";

    }

    @PostMapping("/updateskill")

    public String updateskill(@Valid Skill skill) {
        skill.setIsDelete('0');
        skillRepository.save(skill);
        return "redirect:/skill";

    }
    @GetMapping("/deleteskill")
    public String deleteskill(@Valid Skill skill) {
        skill.setIsDelete('1');
        skillRepository.save(skill);
        return "redirect:/skill";

    }

}
