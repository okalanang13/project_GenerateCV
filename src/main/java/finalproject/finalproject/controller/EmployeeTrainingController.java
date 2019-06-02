/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.services.EmployeeTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class EmployeeTrainingController {

    @Autowired
    private EmployeeTrainingService employeeTrainingService;

    @GetMapping("/employeetraining")
    public String employeetraining(Model model) {
        model.addAttribute("dataEt", employeeTrainingService.findAllEmployeeTraining());
        return "employeetraining";
    }
}
