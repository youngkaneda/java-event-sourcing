/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import es.example.event.store.EventStore;

/**
 *
 * @author kuuhaku
 */
public abstract class Command {
    
    protected final EventStore eventStore;
    
    public Command(EventStore eventStore) {
        this.eventStore = eventStore;
    }
    
    public abstract void execute();
}
