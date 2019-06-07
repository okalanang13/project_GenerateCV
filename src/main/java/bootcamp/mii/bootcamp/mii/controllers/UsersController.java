/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Users;
import bootcamp.mii.bootcamp.mii.repositories.UsersRepository;
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
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("dataUsers", usersService.findAllUsers());
        return "users";
    }

    @PostMapping("/addusers")

    public String addusers(@Valid Users users) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	users.setPassword(bCryptPasswordEncoder.encode("password"));
        users.setIsDelete('0');
        usersRepository.save(users);
        return "redirect:/users";

    }

    @PostMapping("/updateusers")

    public String updateusers(@Valid Users users) {
        users.setIsDelete('0');
        usersRepository.save(users);
        return "redirect:/users";

    }

    @GetMapping("/deleteusers")

    public String deleteusers(@Valid Users users) {
        users.setIsDelete('1');
        usersRepository.save(users);
        return "redirect:/users";

    }
}
