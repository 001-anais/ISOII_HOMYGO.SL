package es.uclm.library.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO base genérico. Proporciona acceso al EntityManager y operaciones
 * por defecto (opcionales) para quienes extiendan esta clase.
 */
public abstract class AbstractEntityDAO {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    protected EntityManager em;

    /** Operaciones genéricas opcionales (no usadas por repos Spring Data) */
    public void selectEntity() { /* opcional */ }
    public void updateEntity() { /* opcional */ }
    public void saveEntity()   { /* opcional */ }
    public void deleteEntity() { /* opcional */ }
}
