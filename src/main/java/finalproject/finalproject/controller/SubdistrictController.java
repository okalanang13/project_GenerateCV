package finalproject.finalproject.controller;

import finalproject.finalproject.repositories.SubdistrictRepository;
import finalproject.finalproject.services.SubdistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author RR17
 */
@Controller
public class SubdistrictController {
    @Autowired
    private SubdistrictService subdistrictService;
    
    @Autowired
    private SubdistrictRepository subdistrictRepository;
    
    @GetMapping("/page/subdistrict")
    public String subdistrict(Model model) {
        model.addAttribute("dataSubdistrict", subdistrictService.findAllSubdistrict());
        return "subdistrict";
    }
}
