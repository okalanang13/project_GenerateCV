/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Organization;
import bootcamp.mii.bootcamp.mii.repositories.OrganizationRepository;
import bootcamp.mii.bootcamp.mii.services.EmployeeService;
import bootcamp.mii.bootcamp.mii.services.OrganizationService;
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
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/organization")
    public String organization(Model model) {
        model.addAttribute("dataorganization", organizationService.findAllOrganization());
        model.addAttribute("dataEmployee", employeeService.findAllEmployee());
        return "organization";
    }

    @PostMapping("/addorganization")

    public String addorganization(@Valid Organization organization) {
        organization.setId(0);
        organization.setIsDelete('0');
        organizationRepository.save(organization);
        return "redirect:/organization";

    }

    @PostMapping("/updateorganization")

    public String updateorganization(@Valid Organization o) {
        o.setIsDelete('0');
        organizationRepository.save(o);
        return "redirect:/organization";

    }

    @GetMapping("/deleteorganization")

    public String deleteorganization(@Valid Organization organization) {
        organization.setIsDelete('1');
        organizationRepository.save(organization);
        return "redirect:/organization";

    }
}
