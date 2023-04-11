package persistence.dto;

import java.io.*;

public class Post_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;
    private int post_num;
    private int user_num;
    private String contents;
    private String title;
    private String dateTime;
    private String region_id;


    public Post_dto(){}

    public Post_dto(int post_num, String contents, String title){
        this.post_num = post_num;
        this.contents = contents;
        this.title = title;
    }

    public Post_dto(int user_name, String contents, String title, String dateTime, String region_id){
        this.user_num = user_name;
        this.contents = contents;
        this.title = title;
        this.dateTime = dateTime;
        this.region_id = region_id;
    }

    public Post_dto(int post_num, int user_name, String contents, String title, String dateTime, String region_id){
        this.post_num = post_num;
        this.user_num = user_name;
        this.contents = contents;
        this.title = title;
        this.dateTime = dateTime;
        this.region_id = region_id;
    }

    public int getPost_num() {
        return post_num;
    }

    public void setPost_num(int post_num) {
        this.post_num = post_num;
    }

    public int getUser_num() {
        return user_num;
    }

    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }
}