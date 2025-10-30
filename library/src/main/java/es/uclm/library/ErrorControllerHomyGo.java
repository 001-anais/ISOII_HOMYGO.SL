package es.uclm.library;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        }

        model.addAttribute("mensaje", mensaje);
        return "error"; // error.html en templates
    }
}

