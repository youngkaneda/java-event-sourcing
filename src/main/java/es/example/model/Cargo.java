package es.example.model;

/**
 * 
 * @author kuuhaku
 */
public class Cargo {
   
    private String name;

    public Cargo() {
    }
    
    public Cargo(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cargo{" + "name=" + name + '}';
    }
}