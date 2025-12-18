package es.uclm.library.business.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InmuebleTest {

    @Test
    void constructorVacio_inicializaListas_yValoresPorDefecto() {
        Inmueble i = new Inmueble();

        assertEquals(0, i.getId());
        assertNull(i.getPropietario());
        assertNull(i.getDireccion());
        assertEquals(0.0, i.getPrecioNoche(), 0.0001);

        assertNotNull(i.getReservas());
        assertNotNull(i.getListaDeseos());
        assertTrue(i.getReservas().isEmpty());
        assertTrue(i.getListaDeseos().isEmpty());

        assertNull(i.getDisponibleDesde());
        assertNull(i.getDisponibleHasta());
        assertNull(i.getImagen());
    }

    @Test
    void gettersYSetters_basicos_funcionanCorrectamente() {
        Inmueble i = new Inmueble();

        i.setDireccion("Calle Mayor 1");
        i.setPrecioNoche(75.5);

        assertEquals("Calle Mayor 1", i.getDireccion());
        assertEquals(75.5, i.getPrecioNoche(), 0.0001);
    }

    @Test
    void setPropietario_asignaCorrectamente() {
        Inmueble i = new Inmueble();
        Propietario p = new Propietario();

        i.setPropietario(p);

        assertSame(p, i.getPropietario());
    }

    @Test
    void setReservas_asignaListaNueva() {
        Inmueble i = new Inmueble();
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());

        i.setReservas(reservas);

        assertSame(reservas, i.getReservas());
        assertEquals(1, i.getReservas().size());
    }

    @Test
    void setListaDeseos_asignaListaNueva() {
        Inmueble i = new Inmueble();
        List<ListaDeseos> listas = new ArrayList<>();
        listas.add(new ListaDeseos());

        i.setListaDeseos(listas);

        assertSame(listas, i.getListaDeseos());
        assertEquals(1, i.getListaDeseos().size());
    }

    @Test
    void fechasDisponibilidad_seAsignanCorrectamente() {
        Inmueble i = new Inmueble();

        Date desde = new Date(1735689600000L); 
        Date hasta = new Date(1736467200000L); 

        i.setDisponibleDesde(desde);
        i.setDisponibleHasta(hasta);

        assertEquals(desde, i.getDisponibleDesde());
        assertEquals(hasta, i.getDisponibleHasta());
    }

    @Test
    void imagen_getSet_funcionaCorrectamente() {
        Inmueble i = new Inmueble();

        i.setImagen("/img/casa.jpg");

        assertEquals("/img/casa.jpg", i.getImagen());
    }
}

