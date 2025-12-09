package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.entity.Reserva;
import es.uclm.library.business.repository.InmuebleRepository;
import es.uclm.library.business.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestorReservas {

    @Autowired
    private ReservaRepository reservaRepository;

    // CORRECTO: solo una definición
    @Autowired
    private InmuebleRepository inmuebleRepository;

    public Reserva registrarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarPorId(int id) {
        return reservaRepository.findById(id);
    }

    public void eliminarReserva(int id) {
        reservaRepository.deleteById(id);
    }

    // Método seguro, sin cambiar tipos ni nombres
    public Inmueble asignarInmueblePorId(int idInmueble) {
        if (inmuebleRepository == null) {
            System.err.println("[ERROR] inmuebleRepository no inyectado correctamente.");
            return null;
        }
        return inmuebleRepository.findById(idInmueble).orElse(null);
    }
}
