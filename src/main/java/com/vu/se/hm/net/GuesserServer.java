/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.net;

import com.vu.se.hm.service.WordGuesser;
import java.io.*;
import java.net.*;

/**
 *
 * @author Dan
 */
public class GuesserServer implements Runnable{
    private ServerSocket server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private volatile WordGuesser guesser;
    
    public GuesserServer(WordGuesser guesser){
        this.guesser = guesser;
        try{
            server = new ServerSocket(1234);
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public void run(){
        try{
            System.out.println("Waiting for connections");
            Socket temp = server.accept();
            out = new ObjectOutputStream(temp.getOutputStream());
            in  = new ObjectInputStream(temp.getInputStream());
            HangmanPacket packet;
            while(guesser.getMissCount()<6){
                packet = (HangmanPacket)in.readObject();
                guesser.guess(packet.letter);
                packet.disguisedWord = guesser.getDisguisedWord();
                packet.missCount = guesser.getMissCount();
                out.writeObject(packet);
            }
            out.close();
            in.close();
            temp.close();
            server.close();
        } catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        } 
    }
}
