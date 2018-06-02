/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.mq;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author kuuhaku
 */
public class ShipMessageListener implements MessageListener{
    
    @Override
    public void onMessage(Message msg) {
        //TODO handle the message
    }
}
