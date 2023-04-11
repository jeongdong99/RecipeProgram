package persistence;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread
{  private Server server    = null;
   private Socket           socket    = null;
   private int              ID        = -1;
   private DataInputStream  streamIn  =  null;
   private DataOutputStream streamOut = null;
   private ObjectOutputStream objectOutputStream = null;
   private ObjectInputStream objectInputStream = null;

   public ServerThread(Server _server, Socket _socket)
   {  super();
      server = _server;
      socket = _socket;
      ID     = socket.getPort();
   }
   public void send(Object obj){
      try {
         objectOutputStream.writeObject(obj);
         objectOutputStream.flush();
      } catch(IOException ioe) {
         System.out.println(ID + " ERROR sending: " + ioe.getMessage());
         server.remove(ID);
         stop();
      }
   }
   public void send(boolean b){
      try {
         streamOut.writeBoolean(b);
         streamOut.flush();
      } catch(IOException ioe) {
         System.out.println(ID + " ERROR sending: " + ioe.getMessage());
         server.remove(ID);
         stop();
      }
   }
   public int getID()
   {  return ID;
   }
   public void run() {
      System.out.println("Server Thread " + ID + " running.");
      while (true) {
         try {
            server.handle(ID, objectInputStream.readObject());
         } catch(IOException ioe) {
            System.out.println(ID + " ERROR reading: " + ioe.getMessage());
            server.remove(ID);
            stop();
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
      }
   }
   public void open() throws IOException
   {  streamIn = new DataInputStream(new 
                        BufferedInputStream(socket.getInputStream()));
      streamOut = new DataOutputStream(new
                        BufferedOutputStream(socket.getOutputStream()));
      objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
      objectInputStream = new ObjectInputStream(socket.getInputStream());
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
      if (streamIn != null)  streamIn.close();
      if (streamOut != null) streamOut.close();
      if (objectInputStream != null) objectInputStream.close();
      if (objectOutputStream != null) objectOutputStream.close();
   }
}
