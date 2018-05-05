package es.example.event;

import es.example.model.Ship;

/**
 * @author Juan
 */
public interface DomainEvent {

    public void process(Ship ship);
}