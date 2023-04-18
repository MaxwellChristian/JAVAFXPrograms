package com.maxwell.javafxprograms.class_tests.simulation_FL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Task implements Runnable{
    public static void sleepRandom(int min,int max) throws InterruptedException {
        Thread.sleep((int)(Math.random()*(max-min)+min)*100);
    }

    int chefID = 0;
    public Task(int chefID){this.chefID=chefID;}
    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 10001);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("CHEF,"+chefID);
            System.out.println("Chef "+chefID+" started");
            while (true) {
                sleepRandom(0, 10);
                String str = in.readUTF();
                if (str.compareToIgnoreCase("WAIT") == 0) {
                    System.out.println("Chef "+(chefID)+" got wait");
                    sleepRandom(10, 20);
                } else {
                    System.out.println("Chef "+(chefID)+" got order:"+str);
                    sleepRandom(0, 20);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Chef {
    private static int chefID=0;
    public static void main(String[] args) throws IOException, InterruptedException {

        new Thread(new Task(1)).start();
        chefID++;
        new Thread(new Task(2)).start();
    }
}
