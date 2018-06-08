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
public class CargoLoadedEvent extends DomainEvent {

    private String cargo;

    public CargoLoadedEvent() {
    }
    
    public CargoLoadedEvent(int shipId, String cargo) {
        super(System.currentTimeMillis(), shipId);
        this.cargo = cargo;
    }

    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }

    public String getCargo() {
        return cargo;
    }
}
