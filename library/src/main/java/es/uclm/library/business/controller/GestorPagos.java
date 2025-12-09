package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Pago;
import es.uclm.library.business.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorPagos {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }
}