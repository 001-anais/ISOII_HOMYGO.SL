package es.uclm.library;

import es.uclm.library.business.controller.GestorBusquedas;
import es.uclm.library.business.entity.Inmueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/busqueda")
public class VentanaBusqueda {

    @Autowired
    private GestorBusquedas gestorBusquedas;

    @GetMapping
    public String mostrarFormularioBusqueda() {
        return "busqueda";
    }

    @PostMapping
    public String buscarInmuebles(@RequestParam String direccion,
                                  @RequestParam double precioMaximo,
                                  Model model) {
        List<Inmueble> resultados = gestorBusquedas.buscarPorDireccion(direccion);
        resultados.retainAll(gestorBusquedas.buscarPorPrecioMaximo(precioMaximo));
        model.addAttribute("resultados", resultados);
        return "resultados";
    }
}
