package persistence;



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyInfo {
    public static String myName;
    public static String myId;
    public static String myPhone;
    public static boolean socketConnect = false;
    public static ObjectInputStream objectInputStream;
    public static ObjectOutputStream objectOutputStream;
    public static Socket socket;
    public static String onePostNum;

    public static String getMyName() {
        return myName;
    }

    public static void setMyName(String myName) {
        MyInfo.myName = myName;
    }

    public static String getMyId() {
        return myId;
    }

    public static void setMyId(String myId) {
        MyInfo.myId = myId;
    }

    public static String getMyPhone() {
        return myPhone;
    }

    public static void setMyPhone(String myPhone) {
        MyInfo.myPhone = myPhone;
    }

    public static boolean isSocketConnect() {
        return socketConnect;
    }

    public static void setSocketConnect(boolean socketConnect) {
        MyInfo.socketConnect = socketConnect;
    }

    public static Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) {
        MyInfo.socket = socket;
    }

    public static String getOnePostNum() {
        return onePostNum;
    }

    public static void setOnePostNum(String onePostNum) {
        MyInfo.onePostNum = onePostNum;
    }

    public static ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public static void setObjectInputStream(ObjectInputStream objectInputStream) {
        MyInfo.objectInputStream = objectInputStream;
    }

    public static ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public static void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        MyInfo.objectOutputStream = objectOutputStream;
    }
}
