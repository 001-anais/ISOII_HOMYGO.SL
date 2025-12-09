// InmuebleRepository.java
package es.uclm.library.business.repository;
import es.uclm.library.business.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer> {
    List<Inmueble> findByDireccionContainingIgnoreCase(String direccion);
    List<Inmueble> findByPrecioNocheLessThanEqual(double precio);
}
