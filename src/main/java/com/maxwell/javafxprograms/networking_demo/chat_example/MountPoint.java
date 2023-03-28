package com.maxwell.javafxprograms.networking_demo.chat_example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MountPoint {
    private Socket socket=null;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    public String getName(){return  name;}
    public static final String SEP = "`";
    public static final String BYE = "bye";

    public boolean isConnected(){return socket!=null;}

    public MountPoint(Socket socket) throws IOException {
        this.socket=socket;
        in  = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        this.name=in.readUTF();
    }

    private String[] sepMsg(String msg)
    {
        return msg.split(SEP);
    }

    public void write(String msg) throws IOException {
        String[] vals = sepMsg(msg);
        if(vals[0].trim().equals(name)) return;
        out.writeUTF(vals[0]+": "+vals[1].trim());
    }

    public String read() throws IOException {
        String msg  = in.readUTF();
        if (msg.equals(BYE))
        {
            socket.close();
            socket = null;
            return BYE;
        }
        else
        return this.name+SEP+msg;
    }




}
