package persistence;

import lombok.Getter;
import lombok.Setter;

import java.net.Socket;

@Setter
@Getter
public class MyInfo {
    public static String myName;
    public static String myId;
    public static String myPhone;
    public static boolean socketConnect = false;
    public static Socket socket;
    public static String onePostNum;


}
