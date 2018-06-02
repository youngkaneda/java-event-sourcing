package es.example.commandes;

import es.example.commandes.infra.ConnFactory;
import es.example.event.ArrivalEvent;
import es.example.event.DepartureEvent;
import es.example.event.LoadEvent;
import es.example.event.NewShipEvent;
import es.example.event.UnloadEvent;
import es.example.event.store.EventStore;
import es.example.model.Cargo;
import es.example.model.Port;
import es.example.model.Ship;
import javax.persistence.EntityManager;

/**
 *
 * @author Juan
 */
public class ShipCommandImpl implements ShipCommand {

    private final Port departurePort;
    private final EventStore evStore;
    private final EntityManager em;

    public ShipCommandImpl() {
        em = ConnFactory.getConnection();
        evStore = EventStore.INSTANCE;
        departurePort = new Port("on the sea");
    }

    @Override
    public int newShip(String name, Port port) {
        Ship ship = new Ship(name, port);
        em.getTransaction().begin();
        em.persist(ship);
        em.getTransaction().commit();
        NewShipEvent event = new NewShipEvent(System.currentTimeMillis(), ship.getId(), name, port);
        evStore.store(event);
        return ship.getId();
    }

    @Override
    public void loadCargo(int id, Cargo cargo) {
        em.getTransaction().begin();
        Ship ship = em.find(Ship.class, id);
        ship.addCargo(cargo);
        em.getTransaction().commit();
        LoadEvent event = new LoadEvent(id, cargo);
        evStore.store(event);
    }

    @Override
    public void unloadCargo(int id) {
        em.getTransaction().begin();
        Ship ship = em.find(Ship.class, id);
        ship.emptyCargo();
        em.getTransaction().commit();
        UnloadEvent event = new UnloadEvent(ship.getId());
        evStore.store(event);
    }

    @Override
    public void departureShip(int id) {
        em.getTransaction().begin();
        Ship ship = em.find(Ship.class, id);
        ship.setPort(this.departurePort);
        em.getTransaction().commit();
        DepartureEvent event = new DepartureEvent(ship.getId(), this.departurePort);
        evStore.store(event);
    }

    @Override
    public void arrivalShip(int id, Port port) {
        em.getTransaction().begin();
        Ship ship = em.find(Ship.class, id);
        ship.setPort(port);
        em.getTransaction().commit();
        ArrivalEvent event = new ArrivalEvent(ship.getId(), port);
        evStore.store(event);
    }

    @Override
    public void close() {
        em.close();
    }
}
