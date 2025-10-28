package es.uclm.library.business.controller;

import org.springframework.stereotype.Service;

@Service
public class GestorNotificaciones {

    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("📨 Notificación enviada a " + destinatario + ": " + mensaje);
    }
}
