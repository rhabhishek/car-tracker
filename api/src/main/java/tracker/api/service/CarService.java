package tracker.api.service;

import tracker.api.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> updateVehicles(List<Car> carList);

    Car findByVin(String vin);

}
