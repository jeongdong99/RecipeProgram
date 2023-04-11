package persistence;

import java.net.*;
import java.io.*;
import java.util.Scanner;

//import persistence.Serializer;

public class Client implements Runnable {
   private Socket socket              = null;
   private Thread thread              = null;
   private DataInputStream  console   = null;
   private DataOutputStream streamOut = null;
   private ClientThread client    = null;
   //private Serializer serializer = null;
   Scanner s = new Scanner(System.in);

   public Client(String serverName, int serverPort) {
      System.out.println("Establishing connection. Please wait ...");
      try {
         socket = new Socket(serverName, serverPort);
         System.out.println("Connected: " + socket);
         start();
      } catch(UnknownHostException uhe) {
         System.out.println("Host unknown: " + uhe.getMessage());
      } catch(IOException ioe) {
         System.out.println("Unexpected exception: " + ioe.getMessage());
      }
   }
   // 여기서 ClientControl 실행
   public void run() {
      while (thread != null) {
         try{
            String str = s.nextLine();
            streamOut.writeUTF(str);
            streamOut.flush();
         } catch(IOException ioe) {
            System.out.println("Sending error: " + ioe.getMessage());
            stop();
         }
      }
   }
   public void handle(String msg) {
      if (msg.equals(".bye")) {
         System.out.println("Good bye. Press RETURN to exit ...");
         stop();
      }else {
         System.out.println(msg);
      }
   }
   public void handle(Object object){
      // 여기에 내용 입력
   }
   public void start() throws IOException
   {  console   = new DataInputStream(System.in);
      streamOut = new DataOutputStream(socket.getOutputStream());
      if (thread == null)
      {  client = new ClientThread(this, socket);
         thread = new Thread(this);                   
         thread.start();
         //serializer = new Serializer();
      }
   }
   public void stop()
   {  if (thread != null)
      {  thread.stop();  
         thread = null;
      }
      try
      {  if (console   != null)  console.close();
         if (streamOut != null)  streamOut.close();
         if (socket    != null)  socket.close();
      }
      catch(IOException ioe) {
         System.out.println("Error closing ...");
      }
      client.close();  
      client.stop();
   }
   public static void main(String args[]) {
      Client client = null;
      // check
      // 밑에 args[0]을 서버 ip로 바꿔야 됨
      client = new Client("127.0.0.1", 2400);
   }
}
