/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Achievement;
import bootcamp.mii.bootcamp.mii.repositories.AchievementRepository;
import bootcamp.mii.bootcamp.mii.services.AchievementService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private AchievementRepository achievementRepository;

    @InitBinder

    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true, 10));

    }

    @GetMapping("/achievement")
    public String achievement(Model model) {
        model.addAttribute("dataAchievement", achievementService.findAllAchievement());
        return "achievement";
    }

    @PostMapping("/addachievement")

    public String addachievement(@Valid Achievement achievement) {
        achievement.setIsDelete('0');
        achievementRepository.save(achievement);
        return "redirect:/achievement";

    }

    @PostMapping("/updateachievement/{id}")

    public String updateachievement(@PathVariable("id") String id,Achievement a) {
        a.setIsDelete('0');
        achievementRepository.save(a);
        return "redirect:/achievement";

    }
    
    @GetMapping("/deleteachievement/{id}")

    public String deleteachievement(@PathVariable("id") String id,Achievement a) {
        achievementRepository.delete(a);
        return "redirect:/achievement";

    }
}
