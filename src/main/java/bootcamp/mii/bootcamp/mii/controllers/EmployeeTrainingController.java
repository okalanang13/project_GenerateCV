/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Employee;
import bootcamp.mii.bootcamp.mii.entities.EmployeeTraining;
import bootcamp.mii.bootcamp.mii.repositories.EmployeeTrainingRepository;
import bootcamp.mii.bootcamp.mii.services.EmployeeService;
import bootcamp.mii.bootcamp.mii.services.EmployeeTrainingService;
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
public class EmployeeTrainingController {

    @Autowired
    private EmployeeTrainingService employeeTrainingService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private TrainingService TrainingService;
    
    @Autowired
    private EmployeeTrainingRepository employeeTrainingRepository;

    @GetMapping("/employeetraining")
    public String employeetraining(Model model) {
        model.addAttribute("dataET", employeeTrainingService.findAllEmployeeTraining());
        model.addAttribute("dataEmployee", employeeService.findAllEmployee());
        model.addAttribute("dataTraining", TrainingService.findAllTraining());
        return "employeetraining";
    }

    @PostMapping("/addemployeetraining")

    public String addemployeetraining(@Valid EmployeeTraining employee) {
        employee.setId(0);
        employee.setIsDelete('0');
        employeeTrainingRepository.save(employee);
        return "redirect:/employeetraining";

    }

    @PostMapping("/updateemployeetraining")

    public String updateemployeetraining(@Valid EmployeeTraining e) {
        e.setIsDelete('0');
        employeeTrainingRepository.save(e);
        return "redirect:/employeetraining";

    }

    @GetMapping("/deleteemployeetraining")

    public String deleteemployeetraining(@Valid EmployeeTraining e) {
        e.setIsDelete('1');
        employeeTrainingRepository.save(e);
        return "redirect:/employeetraining";

    }
}
