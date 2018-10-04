package es.example.event;

import es.example.model.Ship;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author kuuhaku
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(initialValue = 1, name = "de_seq")
public abstract class DomainEvent implements Serializable{

    @Id
    @GeneratedValue(generator ="de_seq", strategy =GenerationType.SEQUENCE)
    private int id;
    private long createdIn;
    private int shipId;
    private String type;
    
    public DomainEvent() {
    }
    
    public DomainEvent(long timeMillis, int shipId) {
        this.type = getClass().getName();
        this.createdIn = timeMillis;
        this.shipId = shipId;
    }

    public abstract void applyOn(Ship ship);
    
    public long getCreatedIn() {
        return createdIn;
    }

    public int getShipId() {
        return shipId;
    }

    public String getType() {
        return type;
    }
}
