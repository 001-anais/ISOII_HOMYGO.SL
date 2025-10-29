// ReservaRepository.java
package es.uclm.library.business.repository;
import es.uclm.library.business.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {}
