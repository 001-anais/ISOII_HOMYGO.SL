// UsuarioRepository.java
package es.uclm.library.business.repository;
import es.uclm.library.business.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}
