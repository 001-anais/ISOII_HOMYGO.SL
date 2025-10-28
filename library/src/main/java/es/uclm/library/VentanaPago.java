package es.uclm.library;

import es.uclm.library.business.controller.GestorPagos;
import es.uclm.library.business.entity.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pago")
public class VentanaPago {

    @Autowired
    private GestorPagos gestorPagos;

    @GetMapping("/nuevo")
    public String mostrarFormularioPago(Model model) {
        model.addAttribute("pago", new Pago());
        return "pago";
    }

    @PostMapping("/procesar")
    public String procesarPago(@ModelAttribute Pago pago, Model model) {
        gestorPagos.registrarPago(pago);
        model.addAttribute("mensaje", "Pago realizado correctamente.");
        return "resultado_pago";
    }
}
