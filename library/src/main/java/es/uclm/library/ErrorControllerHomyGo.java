package es.uclm.library;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorControllerHomyGo implements ErrorController {


    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object statusCode = request.getAttribute("jakarta.servlet.error.status_code");
        String mensaje;

        if (statusCode != null) {
            int code = Integer.parseInt(statusCode.toString());
            switch (code) {
                case 400:
                    mensaje = "Petición incorrecta (400).";
                    break;
                case 401:
                    mensaje = "No autorizado (401).";
                    break;
                case 403:
                    mensaje = "Acceso prohibido (403).";
                    break;
                case 404:
                    mensaje = "Página no encontrada (404).";
                    break;
                case 500:
                    mensaje = "Error interno del servidor (500).";
                    break;
                default:
                    mensaje = "Se ha producido un error inesperado (" + code + ").";
            }
        } else {
            mensaje = "Se ha producido un error desconocido.";

    @RequestMapping(
        path = "/error",
        method = {
            RequestMethod.GET,
            RequestMethod.POST,
            RequestMethod.PUT,
            RequestMethod.DELETE,
            RequestMethod.PATCH,
            RequestMethod.HEAD,
            RequestMethod.OPTIONS
        },
        produces = MediaType.TEXT_HTML_VALUE
    )
    public String handleError(HttpServletRequest request, Model model) {
        Object statusAttr = request.getAttribute("jakarta.servlet.error.status_code");
        int code = parseStatusCode(statusAttr);

        String mensaje;
        switch (code) {
            case 400:
                mensaje = "Petición incorrecta (400).";
                break;
            case 401:
                mensaje = "No autorizado (401).";
                break;
            case 403:
                mensaje = "Acceso prohibido (403).";
                break;
            case 404:
                mensaje = "Página no encontrada (404).";
                break;
            case 500:
                mensaje = "Error interno del servidor (500).";
                break;
            default:
                // Mensaje genérico si no hay código o es desconocido
                mensaje = (code >= 0)
                        ? "Se ha producido un error inesperado (" + code + ")."
                        : "Se ha producido un error desconocido.";
        }

        model.addAttribute("mensaje", mensaje);
        return "error"; // error.html en templates
    }
<<<<<<< HEAD
}

=======

    private int parseStatusCode(Object statusAttr) {
        if (statusAttr == null) return -1;
        if (statusAttr instanceof Number) return ((Number) statusAttr).intValue();
        try {
            return Integer.parseInt(String.valueOf(statusAttr));
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
>>>>>>> features
