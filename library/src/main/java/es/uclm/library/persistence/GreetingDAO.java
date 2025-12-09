package es.uclm.library.persistence;

import es.uclm.library.business.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingDAO extends JpaRepository<Greeting, Long> {
    // Aquí podrías añadir métodos de consulta específicos si los necesitas.
}