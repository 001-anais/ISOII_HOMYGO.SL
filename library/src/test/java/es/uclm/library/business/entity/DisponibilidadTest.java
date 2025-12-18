package es.uclm.library.business.entity;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class DisponibilidadTest {

    @Test
    void constructorVacio_noRompe_yValoresIniciales() {
        Disponibilidad d = new Disponibilidad();

        assertEquals(0, d.getId());
        assertNull(d.getInmueble());
        assertNull(d.getPoliticaCancelacion());
        assertNull(d.getFechaInicio());
        assertNull(d.getFechaFin());
        assertEquals(0.0, d.getPrecio(), 0.0001);
        assertFalse(d.isDirecta());
    }

    @Test
    void gettersYSetters_funcionanCorrectamente() {
        Disponibilidad d = new Disponibilidad();

        Inmueble inmueble = new Inmueble();
        d.setInmueble(inmueble);

        d.setPoliticaCancelacion(PoliticaCancelacion.REEMBOLSABLE);

        Date inicio = Date.valueOf("2025-01-10");
        Date fin = Date.valueOf("2025-01-15");
        d.setFechaInicio(inicio);
        d.setFechaFin(fin);

        d.setPrecio(99.99);
        d.setDirecta(true);

        assertSame(inmueble, d.getInmueble());
        assertEquals(PoliticaCancelacion.REEMBOLSABLE, d.getPoliticaCancelacion());
        assertEquals(inicio, d.getFechaInicio());
        assertEquals(fin, d.getFechaFin());
        assertEquals(99.99, d.getPrecio(), 0.0001);
        assertTrue(d.isDirecta());
    }

    @Test
    void setDirecta_falseFunciona() {
        Disponibilidad d = new Disponibilidad();

        d.setDirecta(true);
        assertTrue(d.isDirecta());

        d.setDirecta(false);
        assertFalse(d.isDirecta());
    }
}


