/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.event.repository;

import es.example.specification.JPASpecification;
import es.example.specification.Specification;
import es.example.infra.PGConnFactory;
import es.example.event.DomainEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author kuuhaku
 */
public class JPAEventRepository implements EventRepository<DomainEvent> {

    private final EntityManager em;
    
    public JPAEventRepository(String persistence_unit) {
        em = PGConnFactory.getConnection(persistence_unit);
    }

    @Override
    public void save(DomainEvent event) {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
    }

    @Override
    public List<DomainEvent> query(Specification spec) {
        JPASpecification jpaSpec = (JPASpecification) spec;
        TypedQuery<DomainEvent> query = em.createQuery(jpaSpec.toSqlQuery(), DomainEvent.class);
        return query.getResultList();
    }

    @Override
    public void close() {
        em.close();
    }

}
