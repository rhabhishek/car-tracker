package tracker.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tracker.api.entity.Car;
import tracker.api.entity.Reading;
import tracker.api.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository repository;

    @Transactional
    public Car createVehicle(Car car) {
        return repository.create(car);
    }

    @Transactional
    public List<Car> updateVehicles(List<Car> carList) {
        for (Car car : carList) {
            Car existing = repository.findOne(car.getVin());
            if (existing == null) {
                createVehicle(car);
            } else {
                repository.update(car);
            }
        }
        return carList;
    }

    @Transactional
    public Reading createReading(Reading reading) {
        return repository.createReading(reading);
    }
}
