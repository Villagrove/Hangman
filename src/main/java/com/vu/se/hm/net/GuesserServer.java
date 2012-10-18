/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.net;

import com.vu.se.hm.service.*;
import com.vu.se.hm.service.impl.WordGuesserImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Dan
 */
public class GuesserServer implements Runnable{
    private ConcurrentLinkedQueue queue;
    private WordGuesser guesser;
    private List players;
    private boolean isOver;
    private int port = 1234;
    
    public GuesserServer(String word){
        this.guesser = new WordGuesserImpl(word);
        this.queue = new ConcurrentLinkedQueue();
        this.players = new ArrayList();
        isOver = false;
    }
    
    public void addPlayer(){
        SocketHandler temp = new SocketHandler(queue, port);
        players.add(temp);
        (new Thread(temp)).start();
        port++;
    }
    
    public void sendData(HangmanPacket packet){
        packet.disguisedWord = guesser.getDisguisedWord();
        packet.missCount = guesser.getMissCount();
        Iterator i = players.iterator();
        while(i.hasNext()){
            ((SocketHandler)i.next()).sendData(packet);
        }
    }
    
    @Override
    public void run(){
        HangmanPacket packet;
        while(!isOver){
            if(!queue.isEmpty()){
                packet = (HangmanPacket)queue.remove();
                guesser.guess(packet.letter);
                sendData(packet);
            }
        }
    }
}
