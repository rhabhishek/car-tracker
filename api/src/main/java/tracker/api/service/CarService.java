package tracker.api.service;

import tracker.api.entity.Car;
import tracker.api.entity.Reading;

import java.util.List;

public interface CarService {

    List<Car> updateVehicles(List<Car> carList);

    Reading createReading(Reading reading);
}
