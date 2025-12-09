package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Usuario;
import es.uclm.library.business.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GestorUsuarios {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null || usuario.getLogin().isEmpty())
            throw new Exception("El login es obligatorio.");
        if (usuario.getPass() == null || usuario.getPass().isEmpty())
            throw new Exception("La contraseña es obligatoria.");
        if (usuarioRepository.findByLogin(usuario.getLogin()) != null)
            throw new Exception("Ya existe un usuario con ese login.");

        return usuarioRepository.save(usuario);
    }

    public boolean validarLogin(String login, String pass) {
        Usuario u = usuarioRepository.findByLogin(login);
        return (u != null && u.getPass().equals(pass));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}