/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Dan
 */
public class GuesserClient implements Guesser, Runnable{

    private List listeners;
    private volatile int missCount;
    private volatile String disguisedWord;
    private volatile Set<Character> lettersGuessed = new HashSet<Character>();
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    private volatile boolean connected;
    
    public GuesserClient(){
        listeners = new ArrayList();
        out = null;
        in = null;
        socket = null;
        disguisedWord = "";
        missCount = 0;
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
    
    @Override
    public String guess(char letter) {
        HangmanPacket packet = new HangmanPacket();
        packet.letter = letter;
        sendData(packet);
        return disguisedWord;
    }

    @Override
    public String getDisguisedWord() {
        return disguisedWord;
    }

    @Override
    public int getMissCount() {
        return missCount;
    }

    @Override
    public Set<Character> getLettersGuessed() {
        return lettersGuessed;
    }

    public void connect(String address, int port){
        try{
            socket = new Socket(address, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            connected = true;
        } catch (IOException e){
            System.out.println("Could not connect to Host:" + e);
        }
    }
    
    public void close(){
        try{
            out.close();
            in.close();
            socket.close();
            connected = false;
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public void sendData(HangmanPacket packet){
        try{
            out.writeObject(packet);
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void run() {
        HangmanPacket packet;
        try{
            while(connected){
                packet = (HangmanPacket) in.readObject();
                if (packet != null)
                {
                    this.missCount = packet.missCount;
                    this.disguisedWord = packet.disguisedWord;
                    lettersGuessed.add(packet.letter);
                    fireEvent(packet.letter);
                }
            }
        } catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
