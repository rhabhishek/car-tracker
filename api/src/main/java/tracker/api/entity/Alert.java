package tracker.api.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import tracker.api.util.AlertPriority;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findAll",
                query = "SELECT alert FROM Alert alert ORDER BY alert.timestamp DESC")
})
public class Alert {

    @Id
    private String id;
    private AlertPriority priority;
    private String message;
    private Timestamp timestamp;


    public Alert() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AlertPriority getPriority() {
        return priority;
    }

    public void setPriority(AlertPriority priority) {
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
