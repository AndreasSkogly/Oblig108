package org.example.weboppg7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("handleliste") // holder listen mellom requests
public class HandlelisteController {

    // Initialiser handlelisten når session starter
    @ModelAttribute("handleliste")
    public List<String> initHandleliste() {
        return new ArrayList<>();
    }

    // Login-side
    @GetMapping("/")
    public String visLogin() {
        return "login";
    }

    // Håndter passord og gå videre til handleliste
    @PostMapping("/handleliste")
    public String nesteSide(@RequestParam("psw") String passord, Model model) {
        model.addAttribute("psw", passord);
        return "handleliste";
    }

    // Legg til vare
    @PostMapping("/handleliste/leggTil")
    public String leggTilVare(@RequestParam("vare") String vare,
                              @ModelAttribute("handleliste") List<String> handleliste,
                              RedirectAttributes redirectAttributes) {
        if (!vare.isBlank()) {
            handleliste.add(vare);
        }
        redirectAttributes.addFlashAttribute("melding", "Varen er lagt til!");
        return "redirect:/handleliste";
    }

    // Slett vare
    @PostMapping("/handleliste/slett")
    public String slettVare(@RequestParam("vare") String vare,
                            @ModelAttribute("handleliste") List<String> handleliste,
                            RedirectAttributes redirectAttributes) {
        handleliste.remove(vare);
        redirectAttributes.addFlashAttribute("melding", "Varen er slettet!");
        return "redirect:/handleliste";
    }

    // Vis handleliste (GET)
    @GetMapping("/handleliste")
    public String visHandleliste(@ModelAttribute("handleliste") List<String> handleliste,
                                 Model model) {
        model.addAttribute("handleliste", handleliste);
        return "handleliste";
    }
}
