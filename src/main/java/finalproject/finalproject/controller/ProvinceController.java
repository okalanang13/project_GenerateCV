package finalproject.finalproject.controller;

import finalproject.finalproject.entities.Province;
import finalproject.finalproject.repositories.ProvinceRepository;
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
public class ProvinceController {
    
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private ProvinceRepository provinceRepository;
    
    @Autowired
    private ProvinceService provinceService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/province")
    public String province(Model model) {
        model.addAttribute("dataProvince", provinceService.findAllProvince());
        return "province";
    }
    
    //proses tambah data dengan fungsi save dari Crud Repository
    @PostMapping("/addDataProvince")
    public String addDataProvince (@Valid Province province){
        provinceRepository.save(province);
        return "province";
    }
    
}
