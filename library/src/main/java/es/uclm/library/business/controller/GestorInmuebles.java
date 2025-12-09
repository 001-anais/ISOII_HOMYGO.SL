package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GestorInmuebles {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    public List<Inmueble> listarInmuebles() {
        return inmuebleRepository.findAll();
    }

    public Inmueble registrarInmueble(Inmueble inmueble) {
    	 if (inmueble.getImagen() == null || inmueble.getImagen().isEmpty()) {
    	        inmueble.setImagen("/img/default_house.jpg");
    	    }
    	return inmuebleRepository.save(inmueble);
    }

    public Optional<Inmueble> buscarPorId(int id) {
        return inmuebleRepository.findById(id);
    }

    public void eliminarInmueble(int id) {
        inmuebleRepository.deleteById(id);
    }
}