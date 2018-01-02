package tracker.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tracker.api.entity.Alert;
import tracker.api.entity.Car;
import tracker.api.entity.Reading;
import tracker.api.entity.Tires;
import tracker.api.repository.AlertRepository;
import tracker.api.repository.ReadingRepository;
import tracker.api.util.AlertPriority;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    AlertRepository alertRepository;

    @Autowired
    CarService carService;

    @Transactional
    public Reading createReading(Reading reading) {

        readingRepository.createReading(reading);
        List<Alert> alertList = monitorReading(reading);
        if (alertList.size() != 0) {
            for (Alert alert : alertList) {
                alertRepository.createAlert(alert);
            }
        }
        return reading;

    }

    private List<Alert> monitorReading(Reading reading) {
        Car car = carService.findByVin(reading.getVin());
        Alert alert;
        List<Alert> alertList = new ArrayList<Alert>();
        if (reading.getEngineRpm() > car.getRedlineRpm()) {
            alert = new Alert();
            alert.setPriority(AlertPriority.HIGH);
            alert.setMessage("Engine RPM (" + reading.getEngineRpm() + ")greater than Red Line RPM (" + car.getRedlineRpm() + ").");
            alertList.add(alert);
        }

        if (reading.getFuelVolume() < 0.1 * car.getMaxFuelVolume()) {
            alert = new Alert();
            alert.setPriority(AlertPriority.MEDIUM);
            alert.setMessage("Fuel (" + reading.getFuelVolume() + "%) is less than 10%.");
            alertList.add(alert);
        }
        Tires tires = reading.getTires();
        if (tires.getFrontLeft() < 32 || tires.getFrontLeft() > 36) {
            alert = new Alert();
            alert.setPriority(AlertPriority.LOW);
            alert.setMessage("Check Front Left tire pressure(" + tires.getFrontLeft() + ").");
            alertList.add(alert);
        }
        if (tires.getFrontRight() < 32 || tires.getFrontRight() > 36) {
            alert = new Alert();
            alert.setPriority(AlertPriority.LOW);
            alert.setMessage("Check Front Right tire pressure(" + tires.getFrontRight() + ").");
            alertList.add(alert);
        }
        if (tires.getRearLeft() < 32 || tires.getRearLeft() > 36) {
            alert = new Alert();
            alert.setPriority(AlertPriority.LOW);
            alert.setMessage("Check Rear Left tire pressure(" + tires.getRearLeft() + ").");
            alertList.add(alert);
        }
        if (tires.getRearRight() < 32 || tires.getRearRight() > 36) {
            alert = new Alert();
            alert.setPriority(AlertPriority.LOW);
            alert.setMessage("Check Rear Right tire pressure(" + tires.getRearRight() + ").");
            alertList.add(alert);
        }
        if (reading.isEngineCoolantLow()) {
            alert = new Alert();
            alert.setPriority(AlertPriority.LOW);
            alert.setMessage("Engine coolant LOW");
            alertList.add(alert);
        }
        if (reading.isCheckEngineLightOn()) {
            alert = new Alert();
            alert.setPriority(AlertPriority.LOW);
            alert.setMessage("Check Engine Light.");
            alertList.add(alert);
        }
        return alertList;
    }
}
