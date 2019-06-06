/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Language;
import finalproject.finalproject.repositories.LanguageRepository;
import finalproject.finalproject.services.LanguageService;
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
public class LanguageController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private LanguageRepository languageRepository;
    
    @Autowired
    private LanguageService languageService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/language")
    public String language(Model model) {
        model.addAttribute("dataLanguage", languageService.getAllLanguage());
        return "language";
    }
    
    @PostMapping("/page/language/addDataLanguage")
    public String addDataLanguage (@Valid Language language){
        language.setIsDelete("false");
        languageRepository.save(language);
        return "redirect:/page/language";
    }
    
    //proses update data dengan fungsi save dari Crud Repository
    @PostMapping("/page/language/updateDataLanguage")
    public String updateDataJob(@Valid Language language) {
        language.setIsDelete("false");
        languageRepository.save(language);
        return "redirect:/page/language";

    }

    //proses softdelete data dengan fungsi save dari Crud Repository
    @GetMapping("/page/language/softDeleteDataLanguage")
    public String softDeleteDataLanguage(@Valid Language language) {
        language.setIsDelete("true");
        languageRepository.save(language);
        return "redirect:/page/language";

    }
}
