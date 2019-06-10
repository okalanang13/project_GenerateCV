/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Authority;
import bootcamp.mii.bootcamp.mii.services.AuthorityService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import bootcamp.mii.bootcamp.mii.repositories.AuthorityRepository;

/**
 *
 * @author ASUS
 */
@Controller
public class RoleController {
    @Autowired
    private AuthorityService roleService;

    @Autowired
    private AuthorityRepository roleRepository;


    @GetMapping("/role")
    public String role(Model model) {
        model.addAttribute("dataRole", roleService.findAllRole());
        return "role";
    }

    @PostMapping("/addrole")

    public String addrole(@Valid Authority role) {
        role.setId(0);
        role.setIsDelete('0');
        roleRepository.save(role);
        return "redirect:/role";

    }

    @PostMapping("/updaterole")

    public String updaterole(@Valid Authority role) {
        role.setIsDelete('0');
        roleRepository.save(role);
        return "redirect:/role";

    }

    @GetMapping("/deleterole")

    public String deleterole(@Valid Authority role) {
        role.setIsDelete('1');
        roleRepository.save(role);
        return "redirect:/role";

    }
}
