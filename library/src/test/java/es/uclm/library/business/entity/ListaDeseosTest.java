package es.uclm.library.business.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeseosTest {

    @Test
    void constructorVacio_inicializaListaInmuebles_yUsuarioNull() {
        ListaDeseos lista = new ListaDeseos();

        assertEquals(0, lista.getId());

        assertNull(lista.getUsuario());

        assertNotNull(lista.getInmuebles());
        assertTrue(lista.getInmuebles().isEmpty());
    }

    @Test
    void setUsuario_asignaCorrectamente() {
        ListaDeseos lista = new ListaDeseos();
        Inquilino inquilino = new Inquilino();

        lista.setUsuario(inquilino);

        assertSame(inquilino, lista.getUsuario());
    }

    @Test
    void setInmuebles_asignaListaNueva() {
        ListaDeseos lista = new ListaDeseos();
        List<Inmueble> inmuebles = new ArrayList<>();
        inmuebles.add(new Inmueble());

        lista.setInmuebles(inmuebles);

        assertSame(inmuebles, lista.getInmuebles());
        assertEquals(1, lista.getInmuebles().size());
    }

    @Test
    void puedeAsignarListaVacia_sinRomper() {
        ListaDeseos lista = new ListaDeseos();

        lista.setInmuebles(new ArrayList<>());

        assertNotNull(lista.getInmuebles());
        assertTrue(lista.getInmuebles().isEmpty());
    }

    @Test
    void puedeAsignarNull_aUsuario_sinRomper() {
        ListaDeseos lista = new ListaDeseos();

        lista.setUsuario(null);

        assertNull(lista.getUsuario());
    }
}

