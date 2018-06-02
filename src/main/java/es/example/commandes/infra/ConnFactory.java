/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.commandes.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kuuhaku
 */
public class ConnFactory {

    private static final String PERSISTENCE_UNIT_NAME = "ship_unit";
    private static EntityManagerFactory factory;

    public static EntityManager getConnection() {
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return factory.createEntityManager();
    }

}
