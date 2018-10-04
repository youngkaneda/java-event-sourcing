/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.read.repository.specification;

import com.mongodb.DBObject;
import es.example.specification.Specification;

/**
 *
 * @author kuuhaku
 */
public interface MongoSpecification extends Specification{
    public DBObject toMongoQuery();
}
