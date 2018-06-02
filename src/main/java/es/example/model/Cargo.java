package es.example.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Juan
 */
@Entity
@SequenceGenerator(name = "cargo_seq", initialValue = 1)
public class Cargo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargo_seq")
    private int id;
    private String name;

    public Cargo() {
    }
    
    public Cargo(String name) {
        this.name = name;
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cargo{" + "id=" + id + ", name=" + name + '}';
    }
}