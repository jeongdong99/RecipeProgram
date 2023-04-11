/*
package persistence.clientControl;

import persistence.Protocol;

import java.io.*;
import java.net.Socket;

public class ClientUserControl {

    private Socket socket;
    DataOutputStream out;
    ObjectInputStream objectInputStream;

    private final String DELIMITER_DATA = "#";
    private final String DELIMITER_PROTOCOL = "\uF0FC";
    private final String DELIMITER_STRING = "\uF042";
    private final String DELIMITER_DTO = "\uF04D";

    public ClientUserControl(Socket socket) throws IOException{
        this.socket = socket;
        out = new DataOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public boolean login(){
        String sendData;
        boolean isSuccess = false;
        String id = "";// textField 에서 받아오는 부분
        String password = "";// textField 에서 받아오는 부분

        String contents = id + "#" + password;
        sendData = makingProtocol(Protocol.REQUEST, Protocol.LOGIN, Protocol.LOG_IN_OUT, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectUserName(){
        String sendData;
        boolean isSuccess = false;
        String name =""; // textField 에서 받아오는 부분

        String contents = name;
        sendData = makingProtocol(Protocol.REQUEST, Protocol.USER, Protocol.SELECT_BY_USER_NAME, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectUserNum(){
        String sendData;
        boolean isSuccess = false;
        String num = ""; // textField 에서 받아오는 부분

        String contents = num;
        sendData = makingProtocol(Protocol.REQUEST, Protocol.USER, Protocol.SELECT_BY_USER_NUM, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean insertUser(){
        String sendData;
        boolean isSuccess = false;
        String id = "";
        String password = "";
        String userName = "";
        String userPhone = "";

        String contents = id + "#" + password + "#" + userName + "#" + userPhone;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.USER, Protocol.INSERT, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    // 받아오는 값들로 프로토콜 만들어야 됨
    // Protocol.REQUEST + Protocol.DELIMITER_PROTOCOL + Protocol.USER + Contents
    private String makingProtocol(int pType, int pAction, int pCode, String contents){
        String result = Integer.toString(pType) + "\uF0FC" + Integer.toString(pAction) + "\uF0FC" + Integer.toString(pCode) + "\uF0FC"
                + contents;
        return result;
    }
}
*/
