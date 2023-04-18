package com.maxwell.javafxprograms.class_tests.simulation_FL;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kitchen {
    private static PriorityQueue<Order> orders=new PriorityQueue<>();
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);
        System.out.println("Kitchen started...");
        while(true)
        {
            Socket socket = serverSocket.accept();
            new Thread(()->{
                try {
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    String str = in.readUTF();
                    String[] list = str.split(",");
                    if(list[0].compareToIgnoreCase("CHEF")==0)
                    {
                        String chefID = list[1];
                        System.out.println(chefID+" is connected");

                        while(true)
                        {
                            Order order=null;
                            try {
                                lock.lock();
                                order = orders.poll();
                                if(order==null)
                                {
                                    out.writeUTF("WAIT");
                                    condition.await();
                                }
                            }finally {
                                lock.unlock();
                            }
                            if (order != null) {
                                String sorder = order.toString();
                                out.writeUTF(sorder);
                                System.out.println(chefID + " will receive order " + sorder);
                            }
                        }


                    }else if(list[0].compareToIgnoreCase("ORDER")==0)
                    {
                        System.out.println(str+" received");
                        Order order = new Order(str);
                        try {
                            lock.lock();
                            orders.add(order);
                            condition.signalAll();
                        }finally {
                            lock.unlock();
                        }



                    }
                    else {
                        System.out.println("Wrong protocol");
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
