/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.repositories.OrganizationRepository;
import bootcamp.mii.bootcamp.mii.services.OrganizationService;
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
public class Organization {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/organization")
    public String organization(Model model) {
        model.addAttribute("dataorganization", organizationService.findAllOrganization());
        return "organization";
    }

    @PostMapping("/addorganization")

    public String addorganization(@Valid bootcamp.mii.bootcamp.mii.entities.Organization organization) {
        organization.setIsDelete('0');
        organizationRepository.save(organization);
        return "redirect:/organization";

    }

    @GetMapping("/updateorganization")

    public String updatereligion(@Valid bootcamp.mii.bootcamp.mii.entities.Organization o) {
        o.setIsDelete('0');
        organizationRepository.save(o);
        return "redirect:/organization";

    }
}
