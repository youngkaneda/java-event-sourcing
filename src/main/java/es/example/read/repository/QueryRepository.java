/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.read.repository;

import es.example.specification.Specification;
import java.util.List;

/**
 *
 * @author kuuhaku
 */
public interface QueryRepository<T> {
    
    public void update(T event);
    
    public List<T> query(Specification spec);
}
