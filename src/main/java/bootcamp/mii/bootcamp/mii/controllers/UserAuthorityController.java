/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.UsersAuthority;
import bootcamp.mii.bootcamp.mii.repositories.UserAuthorityRepository;
import bootcamp.mii.bootcamp.mii.services.AuthorityService;
import bootcamp.mii.bootcamp.mii.services.UserAuthorityService;
import bootcamp.mii.bootcamp.mii.services.UsersService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class UserAuthorityController {

    @Autowired
    private UserAuthorityService userAuthorityService;
    
    @Autowired
    private UsersService userService;
    
    @Autowired
    private AuthorityService authorityService;
    
    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @GetMapping("/userauthority")
    public String userauthority(Model model) {
        model.addAttribute("dataUserauthority", userAuthorityService.findAllUserAuthority());
        model.addAttribute("dataUsers", userService.findAllUsers());
        model.addAttribute("dataAuthority", authorityService.findAllRole());
        return "userauthority";
    }

    @PostMapping("/adduserauthority")

    public String adduserauthority(@Valid UsersAuthority users) {
        users.setIsDelete('0');
        userAuthorityRepository.save(users);
        return "redirect:/userauthority";

    }

    @PostMapping("/updateuserauthority")

    public String updateuserauthority(@Valid UsersAuthority users) {
        users.setIsDelete('0');
        userAuthorityRepository.save(users);
        return "redirect:/userauthority";

    }

    @GetMapping("/deleteuserauthority")

    public String deleteuserauthority(@Valid UsersAuthority users) {
        users.setIsDelete('1');
        userAuthorityRepository.save(users);
        return "redirect:/userauthority";

    }
}
