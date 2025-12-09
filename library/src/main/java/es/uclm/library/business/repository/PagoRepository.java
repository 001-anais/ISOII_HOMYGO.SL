// PagoRepository.java
package es.uclm.library.business.repository;
import es.uclm.library.business.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PagoRepository extends JpaRepository<Pago, Integer> {}