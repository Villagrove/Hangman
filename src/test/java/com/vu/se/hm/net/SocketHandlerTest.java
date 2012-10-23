/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.net;


import java.io.IOException;
import java.net.Socket;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Dan
 */
public class SocketHandlerTest {
    
    ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    public SocketHandlerTest() {
        //queue = new ConcurrentLinkedQueue();
    }

    @Test
    public void testWaitForConnection() throws IOException {
        System.out.println("waitForConnection");
        SocketHandler instance = new SocketHandler(queue, 1234);
        instance.waitForConnection();
        //Socket socket = new Socket("127.0.0.1", 1234);
        //assertTrue(instance.isConnected());
        //socket.close();
        //instance.close();
    }

    @Test
    public void testStopWaitingForConnections() {
        System.out.println("stopWaitingForConnections");
        SocketHandler instance = null;
        instance.stopWaitingForConnections();
        fail("The test case is a prototype.");
    }

    @Test
    public void testClose() {
        System.out.println("close");
        SocketHandler instance = null;
        instance.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSendData() {
        System.out.println("sendData");
        HangmanPacket packet = null;
        SocketHandler instance = null;
        instance.sendData(packet);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRun() {
        System.out.println("run");
        SocketHandler instance = null;
        instance.run();
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        SocketHandler instance = null;
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddToQueue() {
        System.out.println("addToQueue");
        HangmanPacket packet = new HangmanPacket();
        packet.letter = 'A';
        SocketHandler instance = null;
        instance.addToQueue(packet);
        fail("The test case is a prototype.");
    }
}
