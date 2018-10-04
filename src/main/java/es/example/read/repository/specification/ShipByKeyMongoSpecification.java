/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.read.repository.specification;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author kuuhaku
 */
public class ShipByKeyMongoSpecification implements MongoSpecification{

    private String key;
    private Object value;

    public ShipByKeyMongoSpecification(String key, Object value) {
        this.key = key;
        this.value = value;
    }    
    
    @Override
    public DBObject toMongoQuery() {
        return new BasicDBObject(key, value);
    }
}
