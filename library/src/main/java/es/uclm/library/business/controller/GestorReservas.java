package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Reserva;
import es.uclm.library.business.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GestorReservas {

    @Autowired
    private ReservaRepository reservaRepository;

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
}
