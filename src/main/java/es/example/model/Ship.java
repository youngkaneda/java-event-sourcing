package es.example.model;

import java.util.ArrayList;
import java.util.List;

import es.example.event.ArrivedShipEvent;
import es.example.event.DeparturedShipEvent;
import es.example.event.CargoLoadedEvent;
import es.example.event.ShipCreatedEvent;
import es.example.event.CargoUnloadedEvent;

/**
 * 
 * @author kuuhaku
 */
public class Ship {
    
    private int id;
    private String name;
    private Port port;
    private List<Cargo> cargos;
    
    public Ship(){
        this.cargos = new ArrayList<>();
    }
    
    public Ship(String name, Port port) {
        this();
        this.name = name;
        this.port = port;
    }

    public void apply(ShipCreatedEvent event) {
        this.setId(event.getShipId());
        this.setName(event.getName());
        this.setPort(new Port(event.getPort()));
        this.setCargos(new ArrayList<>());
    }
    
    public void apply(CargoLoadedEvent event) {
        this.addCargo(new Cargo(event.getCargo()));
    }

    public void apply(CargoUnloadedEvent event) {
        this.emptyCargo();
    }

    public void apply(DeparturedShipEvent event) {
        this.setPort(new Port(event.getPort()));
    }

    public void apply(ArrivedShipEvent event) {
        this.setPort(new Port(event.getPort()));
    }

    public boolean addCargo(Cargo cargo) {
        return cargos.add(cargo);
    }

    public void emptyCargo() {
        cargos.clear();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Port getPort() {
        return port;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
    
    @Override
    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", port: " + this.port.getName() + ", cargos: " + cargos;
    }
}