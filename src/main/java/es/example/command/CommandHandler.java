/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import java.time.LocalDateTime;

/**
 *
 * @author kuuhaku
 */
public class CommandHandler {

    public static <T extends Command> void handle(T cmd) {
        cmd.execute();
        //TODO: change this for a log4j logging
        System.out.println(String.format("an %s has called in %s", cmd.getClass().getName(), LocalDateTime.now().toString()));
    }
    
}
