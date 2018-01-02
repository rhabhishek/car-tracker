package tracker.api.repository;

import tracker.api.entity.Car;

public interface CarRepository {

    Car findByVin(String vin);

    Car create(Car car);

    Car update(Car car);


}
