package persistence;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import persistence.dto.*;

public class ThreadClient {
    public static void main(String args[]) throws ClassNotFoundException {
        final String HOST = "127.0.0.1";
        final int PORT = 2400;

        System.out.println("Client Program Started!");
        try{
            Socket socket = new Socket(HOST, PORT);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Scanner s = new Scanner(System.in);
            while(true){
                //System.out.print("input : ");
                //String input = s.nextLine();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("user_name", "admin");

                RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.USER, Protocol.SELECT_BY_USER_NAME, hashMap);
                objectOutputStream.writeObject(requestData);
                User_dto user_dto = (User_dto)objectInputStream.readObject();

                System.out.println(user_dto.getUser_name());

                String input = s.nextLine();
                if(input.equals("EXIT")) break;
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
