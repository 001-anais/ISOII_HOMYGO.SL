package es.uclm.library.business.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InquilinoTest {

    @Test
    void constructorVacio_inicializaReservas_yListaDeseosNull() {
        Inquilino inquilino = new Inquilino();

        assertNotNull(inquilino);

        assertNotNull(inquilino.getReservas());
        assertTrue(inquilino.getReservas().isEmpty());

        assertNull(inquilino.getListaDeseos());
    }

    @Test
    void setReservas_asignaListaCorrectamente() {
        Inquilino inquilino = new Inquilino();

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());

        inquilino.setReservas(reservas);

        assertSame(reservas, inquilino.getReservas());
        assertEquals(1, inquilino.getReservas().size());
    }

    @Test
    void setListaDeseos_asignaCorrectamente() {
        Inquilino inquilino = new Inquilino();
        ListaDeseos lista = new ListaDeseos();

        inquilino.setListaDeseos(lista);

        assertSame(lista, inquilino.getListaDeseos());
    }

    @Test
    void puedeAsignarNull_aListaDeseos_sinRomper() {
        Inquilino inquilino = new Inquilino();

        inquilino.setListaDeseos(null);

        assertNull(inquilino.getListaDeseos());
    }

    @Test
    void setReservas_conListaVacia_funciona() {
        Inquilino inquilino = new Inquilino();

        inquilino.setReservas(new ArrayList<>());

        assertNotNull(inquilino.getReservas());
        assertTrue(inquilino.getReservas().isEmpty());
    }
}

