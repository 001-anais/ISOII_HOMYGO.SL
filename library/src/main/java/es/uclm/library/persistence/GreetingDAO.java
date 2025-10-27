package es.uclm.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.uclm.library.business.entity.Greeting;

@Repository
public interface GreetingDAO extends JpaRepository<Greeting, Long> {

}
