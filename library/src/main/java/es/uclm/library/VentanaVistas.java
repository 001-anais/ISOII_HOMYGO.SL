package es.uclm.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador auxiliar para acceder directamente a vistas estáticas
 * sin depender de datos reales en la base de datos.
 */
@Controller
public class VentanaVistas {

    // Vista directa: confirmacion_reserva.html
    @GetMapping("/confirmacion_reserva")
    public String verConfirmacionReservaDirecta(Model model) {
        // Evita errores en Thymeleaf si no hay datos
        model.addAttribute("reserva", null);
        return "confirmacion_reserva";
    }

    // Vista directa: resultado_pago.html
    @GetMapping("/resultado_pago")
    public String verResultadoPagoDirecto(Model model) {
        // Añadimos valores de prueba seguros
        model.addAttribute("mensaje", "Simulación: pago procesado correctamente.");
        model.addAttribute("pago", new Object()); // Objeto genérico para evitar null
        return "resultado_pago";
    }
}