/*
package persistence.clientControl;

import persistence.Protocol;

import java.io.*;
import java.net.Socket;

public class ClientRecipeControl {
    private Socket socket;
    DataOutputStream out;
    ObjectInputStream objectInputStream;

    private final String DELIMITER_DATA = "#";
    private final String DELIMITER_PROTOCOL = "\uF0FC";
    private final String DELIMITER_STRING = "\uF042";
    private final String DELIMITER_DTO = "\uF04D";

    public ClientRecipeControl(Socket socket) throws IOException{
        this.socket = socket;
        out = new DataOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public boolean selectRecipeByIngredientOne(){
        String sendData;
        boolean isSuccess = false;
        String ingredient = "";

        String contents = ingredient;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_ONE_INGREDIENT, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectRecipeByIngredientTwo(){
        String sendData;
        boolean isSuccess = false;
        String ingredient1 = "";
        String ingredient2 = "";

        String contents = ingredient1 + "#" + ingredient2;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_TWO_INGREDIENT, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectRecipeByIngredientThree(){
        String sendData;
        boolean isSuccess = false;
        String ingredient1 = "";
        String ingredient2 = "";
        String ingredient3 = "";

        String contents = ingredient1 + "#" + ingredient2 + "#" + ingredient3;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_THREE_INGREDIENT, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectRecipeByRecipeName(){
        String sendData;
        boolean isSuccess = false;
        String name = "";

        String contents = name;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_NAME, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectRecipeByRecipeLevel(){
        String sendData;
        boolean isSuccess = false;
        String level = "";

        String contents = level;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_RECIPE_LEVEL, contents);

        try{
            out.writeUTF(sendData);
            isSuccess = objectInputStream.readBoolean();
        }catch(IOException e){
            System.out.println(e);
        }
        return isSuccess;
    }

    public boolean selectRecipeByRecipeTime(){
        String sendData;
        boolean isSuccess = false;
        String time = ""; // control에서는 time이 int형임

        String contents = time;

        sendData = makingProtocol(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_RECIPE_TIME, contents);

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
