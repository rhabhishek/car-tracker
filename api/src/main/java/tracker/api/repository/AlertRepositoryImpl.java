package tracker.api.repository;

import org.springframework.stereotype.Repository;
import tracker.api.entity.Alert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Alert createAlert(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }
}
