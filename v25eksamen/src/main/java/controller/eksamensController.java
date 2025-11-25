package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class eksamensController {

    @GetMapping("/")
        public String finnHovedside() {
        return "hovedside";
        }
}
