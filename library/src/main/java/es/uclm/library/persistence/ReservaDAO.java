package es.uclm.library.persistence;

import es.uclm.library.business.entity.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador DAO para Reserva. Ofrece CRUD simple usando JPA.
 * (Si prefieres Spring Data, puedes usar un Repository; esto mantiene la clase pedida).
 */
@Repository
public class ReservaDAO extends AbstractEntityDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Reserva save(Reserva reserva) {
        if (reserva.getId() == 0) {
            em.persist(reserva);
            return reserva;
        } else {
            return em.merge(reserva);
        }
    }

    @Transactional(readOnly = true)
    public Optional<Reserva> findById(int id) {
        return Optional.ofNullable(em.find(Reserva.class, id));
    }

    @Transactional(readOnly = true)
    public List<Reserva> findAll() {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }

    @Transactional
    public void deleteById(int id) {
        findById(id).ifPresent(r -> em.remove(em.contains(r) ? r : em.merge(r)));
    }
}