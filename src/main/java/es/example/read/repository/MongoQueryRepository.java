/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.read.repository;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;
import es.example.read.repository.specification.MongoSpecification;
import es.example.read.repository.strategy.EventStrategy;
import es.example.specification.Specification;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kuuhaku
 */
public class MongoQueryRepository implements QueryRepository<JsonObject> {

    private JsonParser parser;
    private MongoClient mongoClient;
    private DB database;
    private DBCollection collection;
    private EventStrategy strategy;
    
    public MongoQueryRepository(String URI, String DBName, String DBCollection) {
        parser = new JsonParser();
        try {
            this.mongoClient = new MongoClient(new MongoClientURI(URI));
            database = mongoClient.getDB(DBName);
            collection = database.getCollection(DBCollection);
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void update(JsonObject event) {
        strategy = EventStrategy.getStrategy(event.get("type").getAsString());
        DBObject query = new BasicDBObject("shipId", event.get("shipId").getAsInt());
        DBCursor cursor = collection.find(query);
        //if the ship with the given id exist
        if (cursor.size() == 1) {
            DBObject shipDoc = cursor.next();
            JsonObject shipJson = parser.parse(JSON.serialize(shipDoc)).getAsJsonObject();
            strategy.apply(shipJson, event);
            DBObject result = new BasicDBObject("$set", (BasicDBObject) JSON.parse(shipJson.toString()));
            collection.update(query, result);
        } else {
            JsonObject shipJson = new JsonObject();
            strategy.apply(shipJson, event);
            DBObject result = (BasicDBObject) JSON.parse(shipJson.toString());
            collection.insert(result);
        }
    }

    @Override
    public List<JsonObject> query(Specification spec) {
        MongoSpecification mongoSpec = (MongoSpecification) spec;
        DBCursor cursor = collection.find(mongoSpec.toMongoQuery());
        List<JsonObject> shipJsonList = new ArrayList<>();
        while(cursor.hasNext()) {
            DBObject result = cursor.next();
            JsonObject shipJson = (JsonObject) parser.parse(JSON.serialize(result));
            shipJsonList.add(shipJson);
        }
        return shipJsonList;
    }
}
