/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.EmployeeTraining;
import bootcamp.mii.bootcamp.mii.repositories.EmployeeTrainingRepository;
import bootcamp.mii.bootcamp.mii.services.EmployeeTrainingService;
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
public class EmployeeTrainingController {
     @Autowired
    private EmployeeTrainingService employeeTrainingService;

    @Autowired
    private EmployeeTrainingRepository employeeTrainingRepository;

    @GetMapping("/employeetraining")
    public String employeetraining(Model model) {
        model.addAttribute("dataET", employeeTrainingService.findAllEmployeeTraining());
        return "employeetraining";
    }

    @PostMapping("/addemployeetraining")

    public String addemployeetraining(@Valid EmployeeTraining employee) {
        employee.setIsDelete('0');
        employeeTrainingRepository.save(employee);
        return "redirect:/employeetraining";

    }

    @GetMapping("/updateemployeetraining")

    public String updateemployeetraining(@Valid EmployeeTraining e ) {
        e.setIsDelete('0');
        employeeTrainingRepository.save(e);
        return "redirect:/employeetraining";

    }
}
