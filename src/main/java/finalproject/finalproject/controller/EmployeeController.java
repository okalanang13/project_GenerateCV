package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Employee;
import finalproject.finalproject.repositories.EmployeeRepository;
import finalproject.finalproject.services.EmployeeService;
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
    
    @GetMapping("/page/employee")
    public String employee(Model model) {
        model.addAttribute("dataEmployee", employeeService.findAllEmployee());
        return "employee";
    }
    
    @PostMapping("/page/employee/addDataEmployee")
    public String addDataEmployee(@Valid Employee employee){
        employeeRepository.save(employee);
        return "redirect:/page/employee";
    }
}
