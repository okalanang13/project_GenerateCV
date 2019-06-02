package finalproject.finalproject.controller;

import finalproject.finalproject.repositories.DistrictRepository;
import finalproject.finalproject.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author RR17
 */
@Controller
public class DistrictController {
    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private DistrictService districtService;
    
    @GetMapping("/page/district")
    public String district(Model model) {
        model.addAttribute("dataDistrict", districtService.findAllDistrict());
        return "district";
    }
}
