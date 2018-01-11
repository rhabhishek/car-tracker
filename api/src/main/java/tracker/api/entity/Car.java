package tracker.api.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(name = "Car.findByVin", query = "SELECT car FROM Car car WHERE car.vin=:paramVin")
})
public class Car {

    @Id
    @Column(unique = true)
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private int maxFuelVolume;
    private Timestamp lastServiceDate;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }


}
