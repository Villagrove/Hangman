/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.net;

import com.vu.se.hm.gui.HangmanEvent;
import com.vu.se.hm.gui.HangmanEventListener;
import com.vu.se.hm.service.*;
import com.vu.se.hm.service.impl.WordGuesserImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Dan
 */
public class GuesserServer implements WordGuesser, Runnable{
    private List listeners;
    private ConcurrentLinkedQueue queue;
    private WordGuesser guesser;
    private List players;
    private boolean isOver;
    private int port = 1234;
    
    public GuesserServer(String word){
        this.listeners = new ArrayList();
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
                guess(packet.letter);
                fireEvent(packet.letter);
                sendData(packet);
            }
        }
    }

    @Override
    public String guess(char letter) {
        return guesser.guess(letter);
    }

    @Override
    public String getDisguisedWord() {
        return guesser.getDisguisedWord();
    }

    @Override
    public int getMissCount() {
        return guesser.getMissCount();
    }

    @Override
    public Set<Character> getLettersGuessed() {
        return guesser.getLettersGuessed();
    }
    
    public synchronized void addEventListener(HangmanEventListener listener){
        listeners.add(listener);
    }
    
    public synchronized void removeEventListener(HangmanEventListener listener){
        listeners.remove(listener);
    }
    
    private synchronized void fireEvent(char letter){
        HangmanEvent event = new HangmanEvent(this, HangmanEvent.EventType.UPDATE, letter);
        Iterator i = listeners.iterator();
        while(i.hasNext()){
            ((HangmanEventListener) i.next()).handleHangmanEvent(event);
        }
    }
}
