/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.mq;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author kuuhaku
 */
public class AMQProducer {

    private Properties props;
    private Context ctx;
    private ConnectionFactory connFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;
    
    public AMQProducer() {
        try {
            setConfig();
        } catch (NamingException ex) {
            throw new RuntimeException("error trying to set properties configuration: " + ex.getMessage());
        } catch (JMSException ex) {
            throw new RuntimeException("error involving the connection: " + ex.getMessage());
        }
    }

    private void setConfig() throws NamingException, JMSException {
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        props.setProperty("connectionFactoryNames", "connectionFactory");
        props.setProperty("queue.ShipQueue", "es.ship.Queue");
        ctx = new InitialContext(props);
        connFactory = (ConnectionFactory) ctx.lookup("connectionFactory");
        connection = connFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = (Destination) ctx.lookup("ShipQueue");
        producer = session.createProducer(destination);
    }

    public void sendMessage(String text) throws JMSException {
        TextMessage message = session.createTextMessage(text);
        producer.send(message);
    }
    
    public void close() throws JMSException {
        session.close();
        connection.close();
    }
}
