package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "paamelding_med_melding"; // viser JSP
    }

    @PostMapping("/hello")
    public String sayHello(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "paameldt"; // viser JSP
    }
}
