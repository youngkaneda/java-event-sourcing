/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kuuhaku
 */
public class PGConnFactory {
    
    private static EntityManagerFactory factory;

    public static EntityManager getConnection(String persistence_unit) {
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(persistence_unit);
        return factory.createEntityManager();
    }

}
