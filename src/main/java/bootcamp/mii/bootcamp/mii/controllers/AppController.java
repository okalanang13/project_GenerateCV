package bootcamp.mii.bootcamp.mii.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/", "/login"})
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/dashboardadmin")
    public String dashboardadmin() {
        return "dashboardadmin";
    }

    @GetMapping("/dashboarduser")
    public String dashboarduser() {
        return "dashboarduser";
    }
}
