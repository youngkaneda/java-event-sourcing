/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.event.repository.specification;

import es.example.specification.JPASpecification;

/**
 *
 * @author kuuhaku
 */
public class AllEventsSpecification implements JPASpecification{

    @Override
    public String toSqlQuery() {
        return "SELECT e FROM DomainEvent e ORDER BY e.createdIn";
    }
    
}
