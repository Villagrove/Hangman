/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.net;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Dan Cannon
 */
public class SocketHandler implements Runnable{
    private static ServerSocket server;
    private static int maxplayers = 4;
    private static int numplayers = 0;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean connected;
    private volatile ConcurrentLinkedQueue<HangmanPacket> queue;
    
    
    public SocketHandler(ConcurrentLinkedQueue<HangmanPacket> queue, int port){
        try{
            this.queue = queue;
            connected = false;
            if(server == null){
                server = new ServerSocket(port, maxplayers);
            }
            numplayers++;
        } catch (IOException e){
            System.out.println(e);
        }       
    }
    
    public void waitForConnection(){
        System.out.println("Waiting for connections");
        try{
            socket = server.accept();
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            connected = true;
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public void stopWaitingForConnections(){
        try{
            server.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public void close(){
        if(connected){
            try{
                out.close();
                in.close();
                socket.close();
                connected  = false;
                numplayers--;
            if(numplayers <= 0){
                stopWaitingForConnections();
            }
            } catch (IOException e){
                System.out.println(e);
            }
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
        waitForConnection();
        HangmanPacket packet;
        while(connected){
            try{
                packet = (HangmanPacket) in.readObject();
                addToQueue(packet);
            } catch (IOException e){
                System.out.println();
            } catch (ClassNotFoundException e){
                System.out.println();
            }
        }
        close();
    }
    
    public boolean isConnected(){
        return connected;
    }
    
    public synchronized void addToQueue(HangmanPacket packet){
        queue.add(packet);
    }
    
    @Override
    public void finalize() throws Throwable{
        close();
        super.finalize();
    }
}
