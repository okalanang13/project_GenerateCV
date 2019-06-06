/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Training;
import bootcamp.mii.bootcamp.mii.repositories.TrainingRepository;
import bootcamp.mii.bootcamp.mii.services.TrainingService;
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
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingRepository trainingRepository;

    @GetMapping("/training")
    public String training(Model model) {
        model.addAttribute("dataTraining", trainingService.findAllTraining());
        return "training";
    }

    @PostMapping("/addtraining")

    public String addtraining(@Valid Training t) {
        t.setIsDelete('0');
        trainingRepository.save(t);
        return "redirect:/training";

    }

    @PostMapping("/updatetraining")

    public String updatetraining(@Valid Training t) {
        t.setIsDelete('0');
        trainingRepository.save(t);
        return "redirect:/training";
    }

    @GetMapping("/deletetraining")

    public String deletetraining(@Valid Training t) {
        t.setIsDelete('1');
        trainingRepository.save(t);
        return "redirect:/training";
    }
}
