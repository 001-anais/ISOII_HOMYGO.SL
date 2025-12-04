package es.uclm.library;

import es.uclm.library.business.controller.GestorInmuebles;
import es.uclm.library.business.entity.Inmueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inmuebles")
public class VentanaAltaInmuebles {

    @Autowired
    private GestorInmuebles gestorInmuebles;

    @GetMapping("/listar")
    public String listarInmuebles(Model model) {
        model.addAttribute("inmuebles", gestorInmuebles.listarInmuebles());
        return "inmuebles";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioAlta(Model model) {
        model.addAttribute("inmueble", new Inmueble());
        return "inmueble_nuevo";
    }

    // Guardar inmueble (ahora funciona con fechas sin error 400)
    @PostMapping("/guardar")
    public String registrarInmueble(@ModelAttribute Inmueble inmueble) {
        gestorInmuebles.registrarInmueble(inmueble);
        return "redirect:/inmuebles/listar";
    }
}
