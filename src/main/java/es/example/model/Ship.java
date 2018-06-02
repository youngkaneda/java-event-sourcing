package es.example.model;

import java.util.ArrayList;
import java.util.List;

import es.example.event.ArrivalEvent;
import es.example.event.DepartureEvent;
import es.example.event.LoadEvent;
import es.example.event.NewShipEvent;
import es.example.event.UnloadEvent;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Juan
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "ship_seq")
public class Ship implements Serializable {
    
    @Id
    @GeneratedValue(generator = "ship_seq", strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL,
            targetEntity = Port.class)
    private Port port;
    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = Cargo.class)
    private List<Cargo> cargos;
    
    public Ship(){
        this.cargos = new ArrayList<>();
    }
    
    public Ship(String name, Port port) {
        this();
        this.name = name;
        this.port = port;
    }

    public void apply(NewShipEvent event) {
        this.setId(event.getShipId());
        this.setName(event.getName());
        this.setPort(event.getPort());
        this.setCargos(new ArrayList<>());
    }
    
    public void apply(LoadEvent event) {
        this.addCargo(event.getCargo());
    }

    public void apply(UnloadEvent event) {
        this.emptyCargo();
    }

    public void apply(DepartureEvent event) {
        this.setPort(event.getPort());
    }

    public void apply(ArrivalEvent event) {
        this.setPort(event.getPort());
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