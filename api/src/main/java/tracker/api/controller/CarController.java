package tracker.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tracker.api.entity.Car;
import tracker.api.entity.Reading;
import tracker.api.service.CarService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class CarController {
    @Autowired
    CarService service;

    @RequestMapping(method = RequestMethod.PUT, value = "vehicles",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Car> updateVehicles(@RequestBody List<Car> carlist) {
        return service.updateVehicles(carlist);
    }

    @RequestMapping(method = RequestMethod.POST, value = "readings",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createReading(@RequestBody Reading reading) {
        return service.createReading(reading);
    }

}
