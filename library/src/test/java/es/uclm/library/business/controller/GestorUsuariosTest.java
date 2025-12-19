package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Usuario;
import es.uclm.library.business.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GestorUsuariosTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private GestorUsuarios gestorUsuarios;

    @Test
    void registrarUsuario_cuandoDatosValidos_guardaYDevuelveUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setLogin("ana");
        usuario.setPass("1234");

        when(usuarioRepository.findByLogin("ana")).thenReturn(null);
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario res = gestorUsuarios.registrarUsuario(usuario);

        assertNotNull(res);
        assertSame(usuario, res);
        verify(usuarioRepository, times(1)).findByLogin("ana");
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void registrarUsuario_loginNulo_lanzaExcepcion() {
        Usuario usuario = new Usuario();
        usuario.setLogin(null);
        usuario.setPass("1234");

        Exception ex = assertThrows(Exception.class, () -> gestorUsuarios.registrarUsuario(usuario));
        assertEquals("El login es obligatorio.", ex.getMessage());
        verifyNoInteractions(usuarioRepository);
    }

    @Test
    void registrarUsuario_loginVacio_lanzaExcepcion() {
        Usuario usuario = new Usuario();
        usuario.setLogin("");
        usuario.setPass("1234");

        Exception ex = assertThrows(Exception.class, () -> gestorUsuarios.registrarUsuario(usuario));
        assertEquals("El login es obligatorio.", ex.getMessage());
        verifyNoInteractions(usuarioRepository);
    }

    @Test
    void registrarUsuario_passNula_lanzaExcepcion() {
        Usuario usuario = new Usuario();
        usuario.setLogin("ana");
        usuario.setPass(null);

        Exception ex = assertThrows(Exception.class, () -> gestorUsuarios.registrarUsuario(usuario));
        assertEquals("La contraseña es obligatoria.", ex.getMessage());
        verifyNoInteractions(usuarioRepository);
    }

    @Test
    void registrarUsuario_passVacia_lanzaExcepcion() {
        Usuario usuario = new Usuario();
        usuario.setLogin("ana");
        usuario.setPass("");

        Exception ex = assertThrows(Exception.class, () -> gestorUsuarios.registrarUsuario(usuario));
        assertEquals("La contraseña es obligatoria.", ex.getMessage());
        verifyNoInteractions(usuarioRepository);
    }

    @Test
    void registrarUsuario_loginDuplicado_lanzaExcepcion() {
        Usuario usuario = new Usuario();
        usuario.setLogin("ana");
        usuario.setPass("1234");

        when(usuarioRepository.findByLogin("ana")).thenReturn(new Usuario());

        Exception ex = assertThrows(Exception.class, () -> gestorUsuarios.registrarUsuario(usuario));
        assertEquals("Ya existe un usuario con ese login.", ex.getMessage());
        verify(usuarioRepository, times(1)).findByLogin("ana");
        verify(usuarioRepository, never()).save(any());
    }

    @Test
    void validarLogin_cuandoUsuarioNoExiste_devuelveFalse() {
        when(usuarioRepository.findByLogin("ana")).thenReturn(null);

        boolean ok = gestorUsuarios.validarLogin("ana", "1234");

        assertFalse(ok);
        verify(usuarioRepository, times(1)).findByLogin("ana");
    }

    @Test
    void validarLogin_cuandoPassNoCoincide_devuelveFalse() {
        Usuario u = new Usuario();
        u.setPass("abcd");
        when(usuarioRepository.findByLogin("ana")).thenReturn(u);

        boolean ok = gestorUsuarios.validarLogin("ana", "1234");

        assertFalse(ok);
        verify(usuarioRepository, times(1)).findByLogin("ana");
    }

    @Test
    void validarLogin_cuandoPassCoincide_devuelveTrue() {
        Usuario u = new Usuario();
        u.setPass("1234");
        when(usuarioRepository.findByLogin("ana")).thenReturn(u);

        boolean ok = gestorUsuarios.validarLogin("ana", "1234");

        assertTrue(ok);
        verify(usuarioRepository, times(1)).findByLogin("ana");
    }

    @Test
    void listarUsuarios_devuelveListaDelRepositorio() {
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        when(usuarioRepository.findAll()).thenReturn(List.of(u1, u2));

        List<Usuario> res = gestorUsuarios.listarUsuarios();

        assertNotNull(res);
        assertEquals(2, res.size());
        verify(usuarioRepository, times(1)).findAll();
    }
}
