package tracker.api.repository;

import org.springframework.stereotype.Repository;
import tracker.api.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Car findByVin(String vin) {
        return entityManager.find(Car.class, vin);
    }

    public Car create(Car car) {
        entityManager.persist(car);
        return car;
    }

    public Car update(Car car) {
        return entityManager.merge(car);
    }


}
