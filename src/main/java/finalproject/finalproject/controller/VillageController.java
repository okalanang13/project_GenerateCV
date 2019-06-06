package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Village;
import finalproject.finalproject.repositories.VillageRepository;
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
public class VillageController {
    
    @Autowired
    private VillageService villageService;
    
    @Autowired
    private VillageRepository villageRepository;
    
    @GetMapping("/page/village")
    public String village(Model model) {
        model.addAttribute("dataVillage", villageService.findAllVillage());
        return "village";
    }
    
    @PostMapping("/page/village/addDataVillage")
    public String addDataVillage (@Valid Village village){
        villageRepository.save(village);
        return "redirect:/page/village";
    }
}
