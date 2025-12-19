package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Inmueble;
import es.uclm.library.business.repository.InmuebleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GestorBusquedasTest {

    @Mock
    private InmuebleRepository inmuebleRepository;

    @InjectMocks
    private GestorBusquedas gestorBusquedas;

    @Test
    void buscarPorDireccion_llamaAlRepositorio_yDevuelveResultados() {
        Inmueble i1 = new Inmueble();
        Inmueble i2 = new Inmueble();
        when(inmuebleRepository.findByDireccionContainingIgnoreCase("madrid"))
                .thenReturn(List.of(i1, i2));

        List<Inmueble> res = gestorBusquedas.buscarPorDireccion("madrid");

        assertNotNull(res);
        assertEquals(2, res.size());
        verify(inmuebleRepository, times(1))
                .findByDireccionContainingIgnoreCase("madrid");
    }

    @Test
    void buscarPorDireccion_siNoHayResultados_devuelveListaVacia() {
        when(inmuebleRepository.findByDireccionContainingIgnoreCase("zzz"))
                .thenReturn(List.of());

        List<Inmueble> res = gestorBusquedas.buscarPorDireccion("zzz");

        assertNotNull(res);
        assertTrue(res.isEmpty());
        verify(inmuebleRepository, times(1))
                .findByDireccionContainingIgnoreCase("zzz");
    }

    @Test
    void buscarPorPrecioMaximo_llamaAlRepositorio_yDevuelveResultados() {
        Inmueble i1 = new Inmueble();
        when(inmuebleRepository.findByPrecioNocheLessThanEqual(80.0))
                .thenReturn(List.of(i1));

        List<Inmueble> res = gestorBusquedas.buscarPorPrecioMaximo(80.0);

        assertNotNull(res);
        assertEquals(1, res.size());
        verify(inmuebleRepository, times(1))
                .findByPrecioNocheLessThanEqual(80.0);
    }

    @Test
    void buscarPorPrecioMaximo_siNoHayResultados_devuelveListaVacia() {
        when(inmuebleRepository.findByPrecioNocheLessThanEqual(10.0))
                .thenReturn(List.of());

        List<Inmueble> res = gestorBusquedas.buscarPorPrecioMaximo(10.0);

        assertNotNull(res);
        assertTrue(res.isEmpty());
        verify(inmuebleRepository, times(1))
                .findByPrecioNocheLessThanEqual(10.0);
    }
}
