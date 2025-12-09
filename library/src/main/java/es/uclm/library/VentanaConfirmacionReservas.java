package es.uclm.library;

import es.uclm.library.business.controller.GestorReservas;
import es.uclm.library.business.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas/confirmacion")
public class VentanaConfirmacionReservas {

    @Autowired
    private GestorReservas gestorReservas;

    @GetMapping("/{id}")
    public String mostrarConfirmacion(@PathVariable int id, Model model) {
        Reserva reserva = gestorReservas.buscarPorId(id).orElse(null);
        model.addAttribute("reserva", reserva);
        return "confirmacion_reserva";
    }
}