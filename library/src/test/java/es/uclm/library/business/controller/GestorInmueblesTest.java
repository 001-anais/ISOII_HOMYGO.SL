package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.repository.InmuebleRepository;
import org.junit.jupiter.api.BeforeEach;
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
class GestorInmueblesTest {

    @Mock
    private InmuebleRepository inmuebleRepository;

    @InjectMocks
    private GestorInmuebles gestorInmuebles;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listarInmuebles_devuelveListaDelRepositorio() {
        Inmueble i1 = new Inmueble();
        Inmueble i2 = new Inmueble();
        when(inmuebleRepository.findAll()).thenReturn(List.of(i1, i2));

        List<Inmueble> resultado = gestorInmuebles.listarInmuebles();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(inmuebleRepository, times(1)).findAll();
    }

    @Test
    void buscarPorId_devuelveOptionalDelRepositorio() {
        Inmueble i = new Inmueble();
        when(inmuebleRepository.findById(7)).thenReturn(Optional.of(i));

        Optional<Inmueble> res = gestorInmuebles.buscarPorId(7);

        assertTrue(res.isPresent());
        assertSame(i, res.get());
        verify(inmuebleRepository, times(1)).findById(7);
    }

    @Test
    void eliminarInmueble_llamaADeleteById() {
        gestorInmuebles.eliminarInmueble(3);

        verify(inmuebleRepository, times(1)).deleteById(3);
    }

    @Test
    void registrarInmueble_siImagenNula_asignaImagenPorDefecto_yGuarda() {
        Inmueble inmueble = new Inmueble();
        inmueble.setImagen(null);

        when(inmuebleRepository.save(any(Inmueble.class))).thenAnswer(inv -> inv.getArgument(0));

        Inmueble guardado = gestorInmuebles.registrarInmueble(inmueble);

        assertEquals("/img/default_house.jpg", guardado.getImagen());
        verify(inmuebleRepository, times(1)).save(inmueble);
    }

    @Test
    void registrarInmueble_siImagenVacia_asignaImagenPorDefecto_yGuarda() {
        Inmueble inmueble = new Inmueble();
        inmueble.setImagen("");

        when(inmuebleRepository.save(any(Inmueble.class))).thenAnswer(inv -> inv.getArgument(0));

        Inmueble guardado = gestorInmuebles.registrarInmueble(inmueble);

        assertEquals("/img/default_house.jpg", guardado.getImagen());
        verify(inmuebleRepository, times(1)).save(inmueble);
    }
}
