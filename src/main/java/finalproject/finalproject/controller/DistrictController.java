package finalproject.finalproject.controller;

import finalproject.finalproject.entities.District;
import finalproject.finalproject.repositories.DistrictRepository;
import finalproject.finalproject.repositories.ProvinceRepository;
import finalproject.finalproject.services.DistrictService;
import finalproject.finalproject.services.ProvinceService;
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
    
    @Autowired
    private ProvinceRepository provinceRepository;
    
    @Autowired
    private ProvinceService provinceService;
    
    //muncul getAll data dari service
    @GetMapping("/page/district")
    public String district(Model model, District district) {
        model.addAttribute("dataDistrict", districtService.getAllDistrict());
        model.addAttribute("dataProvince", provinceService.getAllProvince());
        return "district";
    }
    
    //proses add daa dengan fungsi save dari crud repo
    @PostMapping("/page/district/addDataDistrict")
    public String addDataDistrict (@Valid District district){
        district.setIsDelete("false");
        districtRepository.save(district);
        return "redirect:/page/district";
    }
    
    //proses update data dengan fungsi save dari Crud Repository
    @PostMapping("/page/district/updateDataDistrict")
    public String updateDataDistrict(@Valid District district) {
        district.setIsDelete("false");
        districtRepository.save(district);
        return "redirect:/page/district";

    }

    //proses softdelete data dengan fungsi save dari Crud Repository
    @GetMapping("/page/district/softDeleteDataDistrict")
    public String softDeleteDataDistrict(@Valid District district) {
        district.setIsDelete("true");
        districtRepository.save(district);
        return "redirect:/page/district";

    }
}
