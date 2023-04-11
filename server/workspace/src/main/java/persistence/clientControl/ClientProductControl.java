/*
package persistence.clientControl;

import persistence.Protocol;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientProductControl {

    private Socket socket;
    DataOutputStream out;
    ObjectInputStream objectInputStream;

    private final String DELIMITER_DATA = "#";
    private final String DELIMITER_PROTOCOL = "\uF0FC";
    private final String DELIMITER_STRING = "\uF042";
    private final String DELIMITER_DTO = "\uF04D";

    public ClientProductControl(Socket socket) throws IOException{
        this.socket = socket;
        out = new DataOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }


    public boolean selectProductName(){
        String sendData;
        boolean isSuccess = false;
        String name = "";

        String contents = name;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectProductPrice(){
        String sendData;
        boolean isSuccess = false;
        String price = "";

        String contents = price;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRICE, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectProductRelatedRecipe(){
        String sendData;
        boolean isSuccess = false;
        String ingredient = "";

        String contents = ingredient;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_RELATED_RECIPE, contents);

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
