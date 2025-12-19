package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.entity.Reserva;
import es.uclm.library.business.repository.InmuebleRepository;
import es.uclm.library.business.repository.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GestorReservasTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private InmuebleRepository inmuebleRepository;

    @InjectMocks
    private GestorReservas gestorReservas;

    @Test
    void registrarReserva_guardaReservaEnRepositorio() {
        Reserva reserva = new Reserva();

        when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva res = gestorReservas.registrarReserva(reserva);

        assertNotNull(res);
        assertSame(reserva, res);
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    void listarReservas_devuelveListaDelRepositorio() {
        Reserva r1 = new Reserva();
        Reserva r2 = new Reserva();

        when(reservaRepository.findAll()).thenReturn(List.of(r1, r2));

        List<Reserva> res = gestorReservas.listarReservas();

        assertNotNull(res);
        assertEquals(2, res.size());
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    void listarReservas_siNoHayReservas_devuelveListaVacia() {
        when(reservaRepository.findAll()).thenReturn(List.of());

        List<Reserva> res = gestorReservas.listarReservas();

        assertNotNull(res);
        assertTrue(res.isEmpty());
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    void buscarPorId_devuelveReservaSiExiste() {
        Reserva reserva = new Reserva();
        when(reservaRepository.findById(4)).thenReturn(Optional.of(reserva));

        Optional<Reserva> res = gestorReservas.buscarPorId(4);

        assertTrue(res.isPresent());
        assertSame(reserva, res.get());
        verify(reservaRepository, times(1)).findById(4);
    }

    @Test
    void buscarPorId_devuelveOptionalVacioSiNoExiste() {
        when(reservaRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Reserva> res = gestorReservas.buscarPorId(99);

        assertTrue(res.isEmpty());
        verify(reservaRepository, times(1)).findById(99);
    }

    @Test
    void eliminarReserva_llamaADeleteById() {
        gestorReservas.eliminarReserva(7);

        verify(reservaRepository, times(1)).deleteById(7);
    }

    @Test
    void asignarInmueblePorId_siExiste_devuelveInmueble() {
        Inmueble inmueble = new Inmueble();
        when(inmuebleRepository.findById(3)).thenReturn(Optional.of(inmueble));

        Inmueble res = gestorReservas.asignarInmueblePorId(3);

        assertNotNull(res);
        assertSame(inmueble, res);
        verify(inmuebleRepository, times(1)).findById(3);
    }

    @Test
    void asignarInmueblePorId_siNoExiste_devuelveNull() {
        when(inmuebleRepository.findById(88)).thenReturn(Optional.empty());

        Inmueble res = gestorReservas.asignarInmueblePorId(88);

        assertNull(res);
        verify(inmuebleRepository, times(1)).findById(88);
    }
}
