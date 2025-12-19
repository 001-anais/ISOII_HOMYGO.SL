package es.uclm.library.business.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliticaCancelacionTest {

    @Test
    void valoresDelEnum_existenYSonCorrectos() {
        PoliticaCancelacion[] valores = PoliticaCancelacion.values();

        assertEquals(3, valores.length);
        assertEquals(PoliticaCancelacion.NO_REEMBOLSABLE, valores[0]);
        assertEquals(PoliticaCancelacion.REEMBOLSABLE, valores[1]);
        assertEquals(PoliticaCancelacion.REEMBOLSABLE_50_PER, valores[2]);
    }

    @Test
    void valueOf_devuelveValorCorrecto() {
        PoliticaCancelacion p = PoliticaCancelacion.valueOf("REEMBOLSABLE");

        assertNotNull(p);
        assertEquals(PoliticaCancelacion.REEMBOLSABLE, p);
    }

    @Test
    void valueOf_conValorInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () ->
                PoliticaCancelacion.valueOf("NO_EXISTE")
        );
    }
}

