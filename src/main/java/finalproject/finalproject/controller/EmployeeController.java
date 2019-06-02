package finalproject.finalproject.controller;

import finalproject.finalproject.repositories.DistrictRepository;
import finalproject.finalproject.repositories.EmployeeRepository;
import finalproject.finalproject.repositories.ProvinceRepository;
import finalproject.finalproject.repositories.ReligionRepository;
import finalproject.finalproject.repositories.SubdistrictRepository;
import finalproject.finalproject.repositories.VillageRepository;
import finalproject.finalproject.services.DistrictService;
import finalproject.finalproject.services.EmployeeService;
import finalproject.finalproject.services.ProvinceService;
import finalproject.finalproject.services.ReligionService;
import finalproject.finalproject.services.SubdistrictService;
import finalproject.finalproject.services.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author RR17
 */
@Controller
public class EmployeeController {
    @Autowired
    private ReligionService religionService;
    
    @Autowired
    private ReligionRepository religionRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ProvinceService provinceService;
    
    @Autowired
    private ProvinceRepository provinceRepository;
    
    @Autowired 
    private DistrictService districtService;
    
    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private SubdistrictService subdistrictService;
    
    @Autowired
    private SubdistrictRepository subdistrictRepository;
    
    @Autowired
    private VillageService villageService;
    
    @Autowired
    private VillageRepository villageRepository;
    
    @GetMapping("/page/employee")
    public String employee(Model model) {
        model.addAttribute("dataEmployee", employeeService.findAllEmployee());
        return "employee";
    }
}
