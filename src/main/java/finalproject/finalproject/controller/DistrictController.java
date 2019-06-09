package finalproject.finalproject.controller;

import finalproject.finalproject.entities.District;
import finalproject.finalproject.repositories.DistrictRepository;
import finalproject.finalproject.services.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private DistrictService districtService;
    
    @GetMapping("/page/district")
    public String district(Model model) {
        model.addAttribute("dataDistrict", districtService.getAllDistrict());
        return "district";
    }
    
    @PostMapping("/page/district/addDataDistrict")
    public String addDataDistrict (@Valid District district){
        districtRepository.save(district);
        return "redirect:/page/district";
    }
}
