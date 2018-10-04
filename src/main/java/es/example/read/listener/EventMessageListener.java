/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.read.listener;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import es.example.read.repository.QueryRepository;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author kuuhaku
 */
public class EventMessageListener implements MessageListener{
    
    private final JsonParser parser;
    private final QueryRepository repo;
    
    public EventMessageListener(JsonParser parser, QueryRepository<JsonObject> repo) {
        this.parser = parser;
        this.repo = repo;
    }
    
    @Override
    public void onMessage(Message msg) {
        TextMessage txtMsg = (TextMessage) msg;
        try {
            JsonObject object = (JsonObject) parser.parse(txtMsg.getText());
            System.out.println("received: " + object);
            repo.update(object);
        } catch (JMSException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
