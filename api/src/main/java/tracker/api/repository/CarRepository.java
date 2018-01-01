package tracker.api.repository;

import tracker.api.entity.Car;
import tracker.api.entity.Reading;

public interface CarRepository {

    Car findOne(String vin);

    Car create(Car car);

    Car update(Car car);

    Reading createReading(Reading reading);

}
