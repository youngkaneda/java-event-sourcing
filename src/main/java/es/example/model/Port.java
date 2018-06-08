package es.example.model;

/**
 * 
 * @author kuuhaku
 */
public class Port {

    private String name;

    public Port() {
    }

    public Port(String name) {
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
        return "name: " + name;
    }
}
