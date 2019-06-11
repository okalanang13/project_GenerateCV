/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.WorkAssignment;
import finalproject.finalproject.repositories.EmployeeRepository;
import finalproject.finalproject.repositories.JobRepository;
import finalproject.finalproject.repositories.WorkAssignmentRepository;
import finalproject.finalproject.services.EmployeeService;
import finalproject.finalproject.services.JobService;
import finalproject.finalproject.services.WorkAssignmentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author RR17
 */
@Controller
public class WorkAssignmentController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private WorkAssignmentRepository workAssignmentRepository;
    
    @Autowired
    private WorkAssignmentService workAssignmentService;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private JobService jobService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/workAssignment")
    public String workAssignment(Model model) {
        model.addAttribute("dataWorkAssignment", workAssignmentService.getAllWorkAss());
        model.addAttribute("dataEmployee", employeeService.getAllEmployee());
        model.addAttribute("dataJob", jobService.getAllJob());
        return "workAssignment";
    }
    
    @PostMapping("/page/workAssignment/addDataWorkass")
    public String addDataWorkass (@Valid WorkAssignment workAssignment){
        workAssignment.setId(0);
        workAssignment.setIsDelete("false");
        workAssignmentRepository.save(workAssignment);
        return "redirect:/page/workAssignment";
    }
    
    //proses update data dengan fungsi save dari Crud Repository
    @PostMapping("/page/workAssignment/updateDataWorkass")
    public String updateDataWorkass(@Valid WorkAssignment workAssignment) {
        workAssignment.setIsDelete("false");
        workAssignmentRepository.save(workAssignment);
        return "redirect:/page/workAssignment";

    }

    //proses softdelete data dengan fungsi save dari Crud Repository
    @GetMapping("/page/workAssignment/softDeleteDataWorkass")
    public String softDeleteDataProvince(@Valid WorkAssignment workAssignment) {
        workAssignment.setIsDelete("true");
        workAssignmentRepository.save(workAssignment);
        return "redirect:/page/workAssignment";

    }
}
