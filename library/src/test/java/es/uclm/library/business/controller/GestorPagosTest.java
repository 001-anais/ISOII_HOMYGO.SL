package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Pago;
import es.uclm.library.business.repository.PagoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GestorPagosTest {

    @Mock
    private PagoRepository pagoRepository;

    @InjectMocks
    private GestorPagos gestorPagos;

    @Test
    void registrarPago_guardaPagoEnRepositorio() {
        Pago pago = new Pago();

        when(pagoRepository.save(pago)).thenReturn(pago);

        Pago res = gestorPagos.registrarPago(pago);

        assertNotNull(res);
        assertSame(pago, res);
        verify(pagoRepository, times(1)).save(pago);
    }

    @Test
    void listarPagos_devuelveListaDelRepositorio() {
        Pago p1 = new Pago();
        Pago p2 = new Pago();

        when(pagoRepository.findAll()).thenReturn(List.of(p1, p2));

        List<Pago> res = gestorPagos.listarPagos();

        assertNotNull(res);
        assertEquals(2, res.size());
        verify(pagoRepository, times(1)).findAll();
    }

    @Test
    void listarPagos_siNoHayPagos_devuelveListaVacia() {
        when(pagoRepository.findAll()).thenReturn(List.of());

        List<Pago> res = gestorPagos.listarPagos();

        assertNotNull(res);
        assertTrue(res.isEmpty());
        verify(pagoRepository, times(1)).findAll();
    }
}
