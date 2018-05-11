package es.example.event;

import es.example.model.Port;

/**
 * @author Juan
 */
public class ArrivalEvent extends DomainEvent{

    private Port port;

    public ArrivalEvent(int shipId, Port port) {
        super(System.currentTimeMillis(), shipId);
        this.port = port;
    }

    /**
     * @return the port
     */
    public Port getPort() {
        return port;
    }
}