package es.uclm.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentanaInicio {

    @GetMapping("/")
    public String mostrarInicio() {
        return "index";
    }
}
