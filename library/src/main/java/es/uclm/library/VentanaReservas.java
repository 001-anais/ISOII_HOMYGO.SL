package es.uclm.library;

import es.uclm.library.business.controller.GestorReservas;
import es.uclm.library.business.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class VentanaReservas {

    @Autowired
    private GestorReservas gestorReservas;

    @GetMapping("/listar")
    public String listarReservas(Model model) {
        model.addAttribute("reservas", gestorReservas.listarReservas());
        return "reservas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reserva_nueva";
    }

    @PostMapping("/guardar")
    public String registrarReserva(@ModelAttribute Reserva reserva) {
        gestorReservas.registrarReserva(reserva);
        return "redirect:/reservas/listar";
    }
}
