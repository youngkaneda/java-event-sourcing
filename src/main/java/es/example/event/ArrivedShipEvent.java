package es.example.event;

import es.example.model.Ship;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 
 * @author kuuhaku
 */
@Entity
@PrimaryKeyJoinColumn(name = "domain_ev")
public class ArrivedShipEvent extends DomainEvent {
    
    private String port;

    public ArrivedShipEvent() {
    }
    
    public ArrivedShipEvent(int shipId, String port) {
        super(System.currentTimeMillis(), shipId);
        this.port = port;
    }

    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }

    public String getPort() {
        return port;
    }
}