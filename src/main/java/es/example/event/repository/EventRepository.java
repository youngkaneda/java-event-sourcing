/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.event.repository;

import es.example.specification.Specification;
import java.util.List;

/**
 *
 * @author kuuhaku
 */
public interface EventRepository<T> {
    
    public void save(T object);
    
    public List<T> query(Specification spec);
    
    public void close();
}
