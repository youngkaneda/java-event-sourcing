/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example;

import com.google.gson.JsonParser;
import es.example.mq.AMQConsumer;
import es.example.mq.Consumer;
import es.example.read.listener.EventMessageListener;
import es.example.read.repository.MongoQueryRepository;

/**
 *
 * @author kuuhaku
 */
public class ReaderThread implements Runnable {

    @Override
    public void run() {
        Consumer consumer = new AMQConsumer("es.ship.Topic");
        consumer.setListener(
                new EventMessageListener(
                        new JsonParser(), new MongoQueryRepository("mongodb://localhost:27017", "ship_db", "ships")
                )
        );
    }
}
