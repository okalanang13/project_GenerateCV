/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Category;
import bootcamp.mii.bootcamp.mii.repositories.CategoryRepository;
import bootcamp.mii.bootcamp.mii.services.CategoryService;
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
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("dataCategory", categoryService.findAllCategory());
        return "category";
    }

    @PostMapping("/addcategory")

    public String addreligion(@Valid Category category) {
        category.setIsDelete('0');
        categoryRepository.save(category);
        return "redirect:/category";

    }

    @GetMapping("/updatecategory")

    public String updatereligion(@Valid Category c ) {
        c.setIsDelete('0');
        categoryRepository.save(c);
        return "redirect:/category";

    }
}
