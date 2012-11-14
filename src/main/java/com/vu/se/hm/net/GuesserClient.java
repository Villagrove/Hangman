
package com.vu.se.hm.net;

import com.vu.se.hm.service.WordGuesser;
import com.vu.se.hm.gui.HangmanEvent;
import com.vu.se.hm.gui.HangmanEventListener;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * GuesserClient. this is the class called when a player wants to join a game
 */
public class GuesserClient implements WordGuesser, Runnable{

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
    
    /**
     * Add an event listener to this class. 
     * The event listener will receive an event when ever the client receives data
     * from the server
     * @param listener the HangmanEventListener to add.
     */
    public synchronized void addEventListener(HangmanEventListener listener){
        listeners.add(listener);
    }
    
    /**
     * Remove event listener
     * @param listener the HangmanEventListener to be removed;
     */
    public synchronized void removeEventListener(HangmanEventListener listener){
        listeners.remove(listener);
    }
    
    /**
     * This is called every time GuesserClient receives a packet form the server
     * @param letter the letter that was guess, can be anything if EventType is not update
     */
    private synchronized void fireEvent(char letter){
        HangmanEvent event = new HangmanEvent(this, HangmanEvent.EventType.UPDATE, letter);
        Iterator i = listeners.iterator();
        while(i.hasNext()){
            ((HangmanEventListener) i.next()).handleHangmanEvent(event);
        }
    }
    
    /**
     * Connect takes an ip address and port and attempts to connect to server
     * @param address the IP address to connect to;
     * @param port the port number the connection will be made at
     */
    public void connect(String address, int port){
        try{
            socket = new Socket(address, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            connected = true;
            sendData(new HangmanPacket(HangmanPacket.PacketType.CONNECT));
        } catch (IOException e){
            System.out.println("Could not connect to Host:" + e);
        }
    }
    
    /**
     * Close, should close sockets and stream reader/writers.
     */
    public void close(){
        if(connected){
            try{
                out.close();
                in.close();
                socket.close();
                connected = false;
            } catch (IOException e){
                System.out.println(e);
            }
        }
    }
    
    /**
     * Sends data to the server;
     * @param packet the HangmanPacket to be sent.
     */
    public void sendData(HangmanPacket packet){
        try{
            out.writeObject(packet);
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    /**
     * Called when new thread is started. While connected is true, continually listen
     * for new packets from server. in.readObject will hang if no date is coming.
     */
    @Override
    public void run() {
        HangmanPacket packet;
        try{
            while(connected){
                packet = (HangmanPacket) in.readObject(); // Will hang until there is an object to read.
                if (packet != null)
                {   
                    switch(packet.type){
                        case GUESS:
                            this.missCount = packet.missCount;
                            this.disguisedWord = packet.disguisedWord;
                            lettersGuessed.add(packet.letter);
                            fireEvent(packet.letter); //Sends an event with data from the server to all listeners
                            break;
                        case WIN:
                            break;
                        case LOSE:
                            break;
                        case KICKED:
                            break;
                        case CONNECT:
                            System.out.println(packet.disguisedWord);
                            break;
                    }
                }
            }
        } catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
        /**
     * Guess, takes a letter and sends it to the server as a guess
     * @param letter the char that is being guessed.
     * @return the disguised word, no longer used.
     */
    @Override
    public String guess(char letter) {
        HangmanPacket packet = new HangmanPacket(HangmanPacket.PacketType.GUESS);
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
    
    @Override
    public String getSecretWord() {
        throw new UnsupportedOperationException("Not supported yet."); //Meeting interface requirements, currently not supported.
    }

    @Override
    public boolean isFound() {
        throw new UnsupportedOperationException("Not supported yet."); //Meeting interface requirements, currently not supported.
    }

    @Override
    public int getGuessCount() {
        throw new UnsupportedOperationException("Not supported yet.");//Meeting interface requirements, currently not supported.
    }

    @Override
    public boolean isGameOver() {
        throw new UnsupportedOperationException("Not supported yet.");//Meeting interface requirements, currently not supported.
    }

    @Override
    public boolean isWrongGuess() {
        throw new UnsupportedOperationException("Not supported yet.");//Meeting interface requirements, currently not supported.
    }
    
    public boolean isConnected(){
        return connected;
    }
    
    /**
     * finalize. Should never be called. Here to make sure connections are close in case of
     * premature exit.
     * @throws Throwable 
     */
    @Override
    public void finalize() throws Throwable{
        close();
        super.finalize();
    }
}
