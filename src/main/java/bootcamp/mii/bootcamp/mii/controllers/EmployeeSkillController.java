/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.EmployeeSkill;
import bootcamp.mii.bootcamp.mii.repositories.EmployeeSkillRepository;
import bootcamp.mii.bootcamp.mii.services.EmployeeSkillService;
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
public class EmployeeSkillController {
    @Autowired
    private EmployeeSkillService employeeSkillService;

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @GetMapping("/employeeskill")
    public String employeeskill(Model model) {
        model.addAttribute("dataES", employeeSkillService.findAllEmployeeSkill());
        return "employeeskill";
    }

    @PostMapping("/addemployeeskill")

    public String addemployeeskill(@Valid EmployeeSkill employeeSkill) {
        employeeSkill.setIsDelete('0');
        employeeSkillRepository.save(employeeSkill);
        return "redirect:/employeeskill";

    }

    @GetMapping("/updateemployeeskill")

    public String updateemployeeskill(@Valid EmployeeSkill e ) {
        e.setIsDelete('0');
        employeeSkillRepository.save(e);
        return "redirect:/employeeskill";

    }
}
