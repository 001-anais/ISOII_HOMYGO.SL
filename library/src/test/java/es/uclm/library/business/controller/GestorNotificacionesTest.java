package es.uclm.library.business.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorNotificacionesTest {

    @Test
    void enviarNotificacion_noLanzaExcepcion_conParametrosValidos() {
        GestorNotificaciones gestor = new GestorNotificaciones();

        assertDoesNotThrow(() ->
                gestor.enviarNotificacion("usuario@test.com", "Mensaje de prueba")
        );
    }

    @Test
    void enviarNotificacion_noLanzaExcepcion_conMensajeVacio() {
        GestorNotificaciones gestor = new GestorNotificaciones();

        assertDoesNotThrow(() ->
                gestor.enviarNotificacion("usuario@test.com", "")
        );
    }

    @Test
    void enviarNotificacion_noLanzaExcepcion_conDestinatarioVacio() {
        GestorNotificaciones gestor = new GestorNotificaciones();

        assertDoesNotThrow(() ->
                gestor.enviarNotificacion("", "Mensaje")
        );
    }

    @Test
    void enviarNotificacion_noLanzaExcepcion_conValoresNull() {
        GestorNotificaciones gestor = new GestorNotificaciones();

        assertDoesNotThrow(() ->
                gestor.enviarNotificacion(null, null)
        );
    }
}
