package persistence.dto;

import java.io.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int user_num;
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_phone;

    public User_dto(){}
    public User_dto(String user_id, String user_password, String user_name, String user_phone){
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_phone = user_phone;
    }
    public User_dto(int user_num, String user_id, String user_password, String user_name, String user_phone){
        this.user_num = user_num;
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_phone = user_phone;
    }

    public int getUser_num() {
        return user_num;
    }

    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
