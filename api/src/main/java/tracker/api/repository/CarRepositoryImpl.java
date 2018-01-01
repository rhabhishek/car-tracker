package tracker.api.repository;

import org.springframework.stereotype.Repository;
import tracker.api.entity.Car;
import tracker.api.entity.Reading;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Car findOne(String vin) {
        return entityManager.find(Car.class, vin);
    }

    public Car create(Car car) {
        entityManager.persist(car);
        return car;
    }

    public Car update(Car car) {
        return entityManager.merge(car);
    }

    public Reading createReading(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }
}
