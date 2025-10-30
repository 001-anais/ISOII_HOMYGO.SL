package es.uclm.library.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Helper para ejecutar SQL nativo cuando sea estrictamente necesario.
 * Para el flujo normal usa siempre los Repositories de Spring Data.
 */
@Repository
public class GestorBD {

    private static final Logger log = LoggerFactory.getLogger(GestorBD.class);

    @PersistenceContext
    private EntityManager em;

    /** Ejecuta un SELECT nativo. Devuelve null por compatibilidad con la firma original. */
    @Transactional(readOnly = true)
    public AbstractEntityDAO select(String sql) {
        log.debug("SQL SELECT: {}", sql);
        Query q = em.createNativeQuery(sql);
        q.getResultList(); // Ejecuta y descarta resultados (la firma original no retornaba datos útiles)
        return null;
    }

    @Transactional
    public void update(String sql) {
        log.debug("SQL UPDATE: {}", sql);
        em.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public void insert(String sql) {
        log.debug("SQL INSERT: {}", sql);
        em.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public void delete(String sql) {
        log.debug("SQL DELETE: {}", sql);
        em.createNativeQuery(sql).executeUpdate();
    }
}
