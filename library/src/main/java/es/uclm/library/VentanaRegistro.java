package es.uclm.library;

import es.uclm.library.business.controller.GestorUsuarios;
import es.uclm.library.business.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class VentanaRegistro {

    @Autowired
    private GestorUsuarios gestorUsuarios;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        try {
            gestorUsuarios.registrarUsuario(usuario);
            model.addAttribute("mensaje", "Usuario registrado correctamente.");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, Model model) {
        boolean valido = gestorUsuarios.validarLogin(usuario.getLogin(), usuario.getPass());
        if (valido) {
            return "redirect:/inmuebles/listar";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }
}