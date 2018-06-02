/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.commandes;

import es.example.model.Cargo;
import es.example.model.Port;

/**
 *
 * @author kuuhaku
 */
public interface ShipCommand {

    int newShip(String name, Port port);

    void loadCargo(int id, Cargo cargo);

    void unloadCargo(int id);
    
    void departureShip(int id);
    
    void arrivalShip(int id, Port port);

    void close();
}
