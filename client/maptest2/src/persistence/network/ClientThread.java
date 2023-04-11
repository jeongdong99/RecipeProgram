package persistence.network;

import java.net.*;
import java.io.*;

public class ClientThread extends Thread {
   private Socket           socket   = null;
   private Client client   = null;
   private DataInputStream  streamIn = null;
   private ObjectInputStream objectInputStream = null;

   public ClientThread(Client _client, Socket _socket)
   {  client   = _client;
      socket   = _socket;
      open();  
      start();
   }
   public void open()
   {  try
      {  streamIn  = new DataInputStream(socket.getInputStream());
         objectInputStream = new ObjectInputStream(socket.getInputStream());
      }
      catch(IOException ioe)
      {  System.out.println("Error getting input stream: " + ioe);
         client.stop();
      }
   }
   public void close()
   {  try
      {  if (streamIn != null) streamIn.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing input stream: " + ioe);
      }
   }
   public void run() {
      // 여기서 clientControl 실행, clientControl 내부에서 objectInputStream.readObject();
      while (true) {
         try {
            client.handle(objectInputStream.readObject());
         }
         catch(IOException ioe) {
            System.out.println("Listening error: " + ioe.getMessage());
            client.stop();
         }
         catch (ClassNotFoundException e) {
         e.printStackTrace();
         }
      }
   }
}
