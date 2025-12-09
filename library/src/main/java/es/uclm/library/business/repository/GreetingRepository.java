// GreetingRepository.java
package es.uclm.library.business.repository;
import es.uclm.library.business.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GreetingRepository extends JpaRepository<Greeting, Long> {}
