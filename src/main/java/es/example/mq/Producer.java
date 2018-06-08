/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.mq;

/**
 *
 * @author kuuhaku
 */
public interface Producer {
    public void send(String text);
    public void close();
}
