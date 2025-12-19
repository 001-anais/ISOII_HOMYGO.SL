package es.uclm.library.business.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    @Test
    void constructorVacio_inicializaCamposANull() {
        Greeting g = new Greeting();

        assertNull(g.getId());
        assertNull(g.getPerson());
        assertNull(g.getContent());
    }

    @Test
    void constructorConParametros_asignaCorrectamenteLosCampos() {
        Greeting g = new Greeting("Ana", "Hola");

        assertEquals("Ana", g.getPerson());
        assertEquals("Hola", g.getContent());
    }

    @Test
    void gettersYSetters_funcionanCorrectamente() {
        Greeting g = new Greeting();

        g.setId(1L);
        g.setPerson("Juan");
        g.setContent("Buenos días");

        assertEquals(1L, g.getId());
        assertEquals("Juan", g.getPerson());
        assertEquals("Buenos días", g.getContent());
    }

    @Test
    void toString_devuelveTextoConCamposPrincipales() {
        Greeting g = new Greeting();
        g.setId(5L);
        g.setPerson("Laura");
        g.setContent("Mensaje");

        String texto = g.toString();

        assertNotNull(texto);
        assertTrue(texto.contains("Greeting"));
        assertTrue(texto.contains("id=5"));
        assertTrue(texto.contains("Laura"));
        assertTrue(texto.contains("Mensaje"));
    }

    @Test
    void permiteValoresNulos_sinLanzarExcepcion() {
        Greeting g = new Greeting(null, null);

        assertNull(g.getPerson());
        assertNull(g.getContent());
    }
}

