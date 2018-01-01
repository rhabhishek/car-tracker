package tracker.api.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Tires {

    @Id
    private String id;

    private float frontRight;
    private float frontLeft;
    private float rearRight;
    private float rearLeft;

    public Tires() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(float frontRight) {
        this.frontRight = frontRight;
    }

    public float getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(float frontLeft) {
        this.frontLeft = frontLeft;
    }

    public float getRearRight() {
        return rearRight;
    }

    public void setRearRight(float rearRight) {
        this.rearRight = rearRight;
    }

    public float getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(float rearLeft) {
        this.rearLeft = rearLeft;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "id='" + id + '\'' +
                ", frontRight=" + frontRight +
                ", frontLeft=" + frontLeft +
                ", rearRight=" + rearRight +
                ", rearLeft=" + rearLeft +
                '}';
    }
}
