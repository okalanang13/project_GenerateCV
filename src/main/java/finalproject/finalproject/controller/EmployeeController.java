package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Employee;
import finalproject.finalproject.repositories.EmployeeRepository;
import finalproject.finalproject.repositories.ReligionRepository;
import finalproject.finalproject.repositories.VillageRepository;
import finalproject.finalproject.services.EmployeeService;
import finalproject.finalproject.services.ReligionService;
import finalproject.finalproject.services.VillageService;
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
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ReligionService religionService;
    
    @Autowired
    private ReligionRepository religionRepository;
    
    @Autowired 
    private VillageService villageService;
    
    @Autowired
    private VillageRepository villageRepository;
    
    
    @GetMapping("/page/employee")
    public String employee(Model model) {
        model.addAttribute("dataEmployee", employeeService.getAllEmployee());
        model.addAttribute("dataReligion", religionService.getAllReligion());
        model.addAttribute("dataVillage", villageService.getAllVillage());
        return "employee";
    }
    
    @PostMapping("/page/employee/addDataEmployee")
    public String addDataEmployee(@Valid Employee employee){
        employee.setIsDelete("false");
        employeeRepository.save(employee);
        return "redirect:/page/employee";
    }
    
    //proses update data dengan fungsi save dari Crud Repository
    @PostMapping("/page/employee/updateDataEmployee")
    public String updateDataEmployee(@Valid Employee employee) {
        employee.setIsDelete("false");
        employeeRepository.save(employee);
        return "redirect:/page/employee";

    }

    //proses softdelete data dengan fungsi save dari Crud Repository
    @GetMapping("/page/employee/softDeleteDataEmployee")
    public String softDeleteDataEmployee(@Valid Employee employee) {
        employee.setIsDelete("true");
        employeeRepository.save(employee);
        return "redirect:/page/employee";

    }
}
