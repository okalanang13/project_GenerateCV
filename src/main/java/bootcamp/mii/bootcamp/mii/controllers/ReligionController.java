/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Religion;
import bootcamp.mii.bootcamp.mii.repositories.ReligionRepository;
import bootcamp.mii.bootcamp.mii.services.ReligionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class ReligionController {

    @Autowired
    private ReligionService religionService;

    @Autowired
    private ReligionRepository religionRepository;

    @GetMapping({"/", "/dashboard"})
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/religion")
    public String religion(Model model) {
        model.addAttribute("dataReligion", religionService.findAllReligion());
        return "religion";
    }

    @PostMapping("/addreligion")

    public String addreligion(@Valid Religion religion) {
        religion.setIsDelete('0');
        religionRepository.save(religion);
        return "redirect:/religion";

    }

    @GetMapping("/updatereligion")

    public String updatereligion(@Valid Religion religion) {
        religion.setIsDelete('0');
        religionRepository.save(religion);
        return "redirect:/religion";

    }

}
