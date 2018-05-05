package es.example.model;

/**
 * @author Juan
 */
public class Cargo {
    private String name;
    private int shipId;
    
    public Cargo(String name) {
        this.name = name;
    };

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the shipId
     */
    public int getShipId() {
        return shipId;
    }

    /**
     * @param shipId the shipId to set
     */
    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", shipId: " + this.shipId;
    }
}