package es.uclm.library;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class VentanaBusqueda {

    private final InmuebleRepository inmuebleRepository;
    
    @Autorwired
    public VentanaBusqueda(InmuebleRepository inmuebleRepository){
        this.inmuebleRepository = inmuebleRepository;
    }

    // Muestra el formulario de búsqueda
    @GetMapping("/busqueda")
    public String mostrarBusqueda() {
        return "busqueda";
    }

    // Muestra resultados filtrados
    @GetMapping("/resultados")
    public String mostrarResultados(
            @RequestParam String zona,
            @RequestParam double precioMaximo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            Model model
    ) {
        List<Inmueble> resultados = inmuebleRepository.findAll().stream()
                .filter(i -> i.getDireccion().toLowerCase().contains(zona.toLowerCase()))
                .filter(i -> i.getPrecioNoche() <= precioMaximo)
                .collect(Collectors.toList());

        model.addAttribute("resultados", resultados);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "resultados";
    }
}
