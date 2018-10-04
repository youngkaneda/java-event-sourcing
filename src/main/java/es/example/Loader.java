/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example;

/**
 *
 * @author kuuhaku
 */
public class Loader {
    public static void main(String[] args) {
        ReaderThread readerThread = new ReaderThread();
        WriterThread writerThread = new WriterThread();
        readerThread.run();
        writerThread.run();
    }
}
