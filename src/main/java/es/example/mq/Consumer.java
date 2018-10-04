/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.mq;

import javax.jms.MessageListener;

/**
 *
 * @author kuuhaku
 */
public interface Consumer {
    public void setListener(MessageListener listener);
    public void close();
}
