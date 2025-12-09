package es.uclm.library;

import es.uclm.library.business.controller.GestorReservas;
import es.uclm.library.business.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/reservas")
public class VentanaReservas {

    @Autowired
    private GestorReservas gestorReservas;

    // ✅ Listar todas las reservas
    @GetMapping("/listar")
    public String listarReservas(Model model) {
        model.addAttribute("reservas", gestorReservas.listarReservas());
        return "reservas";
    }

    // ✅ Formulario de nueva reserva manual
    @GetMapping("/nueva")
    public String mostrarFormularioReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reserva_nueva";
    }

    // ✅ Guardar reserva desde el formulario
    @PostMapping("/guardar")
    public String registrarReserva(@ModelAttribute Reserva reserva) {
        Reserva guardada = gestorReservas.registrarReserva(reserva);
        return "redirect:/reservas/confirmacion?id=" + guardada.getId();
    }

    // ✅ Confirmación (tras crear la reserva)
    @GetMapping("/confirmacion")
    public String mostrarConfirmacionReserva(@RequestParam(required = false) Integer id, Model model) {
        Reserva reserva = (id != null) ? gestorReservas.buscarPorId(id).orElse(null) : null;
        model.addAttribute("reserva", reserva);
        return "confirmacion_reserva";
    }

    // ✅ Vista directa de confirmación (para pruebas sin datos)
    @GetMapping("/ver_confirmacion")
    public String verConfirmacionSinDatos(Model model) {
        model.addAttribute("reserva", null);
        return "confirmacion_reserva";
    }
    @GetMapping("/crear_desde_busqueda")
    public String crearReservaDesdeBusqueda(
            @RequestParam Integer idInmueble,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicio,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFin
    ) {
        Reserva reserva = new Reserva();
        var inmueble = gestorReservas.asignarInmueblePorId(idInmueble);

        if (inmueble == null) {
            return "redirect:/resultados?error=inmuebleNoEncontrado";
        }

        // Validar fechas dentro de disponibilidad
        if (inmueble.getDisponibleDesde() != null && inmueble.getDisponibleHasta() != null) {
            if (fechaInicio.before(inmueble.getDisponibleDesde()) || fechaFin.after(inmueble.getDisponibleHasta())) {
                return "redirect:/resultados?error=fechasNoDisponibles";
            }
        }

        // Calcular noches
        long diffMillis = fechaFin.getTime() - fechaInicio.getTime();
        long noches = Math.max(diffMillis / (1000 * 60 * 60 * 24), 1);
        double total = inmueble.getPrecioNoche() * noches;

        reserva.setInmueble(inmueble);
        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);
        reserva.setPrecioTotal(total);

        reserva = gestorReservas.registrarReserva(reserva);

        // Ir directamente al pago con el ID de la reserva
        return "redirect:/pago?id=" + reserva.getId();
    }

    
}
