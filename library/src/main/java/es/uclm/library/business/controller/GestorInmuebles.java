package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GestorBusquedas {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    public List<Inmueble> buscarPorDireccion(String direccion) {
        return inmuebleRepository.findByDireccionContainingIgnoreCase(direccion);
    }

    public List<Inmueble> buscarPorPrecioMaximo(double precioMaximo) {
        return inmuebleRepository.findByPrecioNocheLessThanEqual(precioMaximo);
    }
}
