package es.uclm.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentanaInicio {

    // Página principal con saludo dinámico
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("nombreUsuario", "Miguel");
        return "index";
    }
}
