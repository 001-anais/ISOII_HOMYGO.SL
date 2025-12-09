package es.uclm.library;

import es.uclm.library.business.controller.GestorPagos;
import es.uclm.library.business.entity.Pago;
import es.uclm.library.business.entity.Reserva;
import es.uclm.library.business.controller.GestorReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pago")
public class VentanaPago {

    @Autowired
    private GestorPagos gestorPagos;

    @Autowired
    private GestorReservas gestorReservas;

    // Mostrar formulario de pago
    @GetMapping
    public String mostrarPago(@RequestParam Integer id, Model model) {
        Reserva reserva = gestorReservas.buscarPorId(id).orElse(null);
        model.addAttribute("reserva", reserva);
        model.addAttribute("pago", new Pago());
        return "pago";
    }

    // Procesar el pago y mostrar resultado
    @PostMapping("/procesar")
    public String procesarPago(@ModelAttribute Pago pago, @RequestParam Integer reservaId, Model model) {
        Reserva reserva = gestorReservas.buscarPorId(reservaId).orElse(null);

        if (reserva == null) {
            model.addAttribute("mensaje", "No se encontró la reserva asociada.");
            return "resultado_pago";
        }

        pago.setReserva(reserva);
        gestorPagos.registrarPago(pago);

        model.addAttribute("mensaje", "Pago realizado correctamente.");
        model.addAttribute("pago", pago);
        return "resultado_pago";  // Carga directamente la vista resultado_pago.html
    }
}