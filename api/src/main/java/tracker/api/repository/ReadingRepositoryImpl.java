package tracker.api.repository;

import org.springframework.stereotype.Repository;
import tracker.api.entity.Reading;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Reading createReading(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }
}
