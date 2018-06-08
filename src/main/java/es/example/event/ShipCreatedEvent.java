/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ShipCreatedEvent extends DomainEvent {

    private String name;
    private String port;

    public ShipCreatedEvent() {
    }
    
    public ShipCreatedEvent(int shipId, String name, String port) {
        super(System.currentTimeMillis(), shipId);
        this.name = name;
        this.port = port;
    }

    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }
}
