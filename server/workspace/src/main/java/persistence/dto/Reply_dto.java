package persistence.dto;

import java.io.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class Reply_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int reply_num;
    private int reply_parent;
    private int post_num;
    private String user_name;
    private String contents;
    private String dateTime;

    public Reply_dto(){}

    public void setContents(String contents){this.contents = contents;}

    public Reply_dto( int post_num, String user_name, String contents,String dateTime){

        this.post_num = post_num;
        this.user_name = user_name;
        this.contents = contents;
        this.dateTime = dateTime;
    }

    public Reply_dto(int reply_num,String dateTime, String contents){
        this.reply_num = reply_num;
        this.dateTime = dateTime;
        this.contents = contents;
    }


    public Reply_dto(int reply_num, int reply_parent,int post_num, String user_name, String contents, String  dateTime){
        this.reply_num = reply_num;
        this.reply_parent = reply_parent;
        this.post_num = post_num;
        this.user_name = user_name;
        this.contents = contents;
        this.dateTime = dateTime;
    }

    public int getReply_num() {
        return reply_num;
    }

    public void setReply_num(int reply_num) {
        this.reply_num = reply_num;
    }

    public int getReply_parent() {
        return reply_parent;
    }

    public void setReply_parent(int reply_parent) {
        this.reply_parent = reply_parent;
    }

    public int getPost_num() {
        return post_num;
    }

    public void setPost_num(int post_num) {
        this.post_num = post_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getContents() {
        return contents;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
