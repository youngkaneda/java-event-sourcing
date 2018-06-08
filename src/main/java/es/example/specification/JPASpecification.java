/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.specification;

/**
 *
 * @author kuuhaku
 */
public interface JPASpecification extends Specification{
    
    public String toSqlQuery();
}
