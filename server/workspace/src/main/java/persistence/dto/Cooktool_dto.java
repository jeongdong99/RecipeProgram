package persistence.dto;

import java.io.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Cooktool_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int cooktool_id;
    private String cooktool_name;
    private String cooktool_price;
    private String cooktool_url;
    private String cooktool_img;

    public Cooktool_dto(){}

    public Cooktool_dto(int cooktool_id, String cooktool_name, String cooktool_price, String cooktool_url, String cooktool_img){
        this.cooktool_id = cooktool_id;
        this.cooktool_name = cooktool_name;
        this.cooktool_price = cooktool_price;
        this.cooktool_url = cooktool_url;
        this.cooktool_img = cooktool_img;
    }

    public int getCooktool_id() {
        return cooktool_id;
    }

    public String getCooktool_name() {
        return cooktool_name;
    }

    public String getCooktool_price() {
        return cooktool_price;
    }

    public String getCooktool_url() {
        return cooktool_url;
    }

    public String getCooktool_img() {
        return cooktool_img;
    }

    public void setCooktool_id(int cooktool_id) {
        this.cooktool_id = cooktool_id;
    }

    public void setCooktool_name(String cooktool_name) {
        this.cooktool_name = cooktool_name;
    }

    public void setCooktool_price(String cooktool_price) {
        this.cooktool_price = cooktool_price;
    }

    public void setCooktool_url(String cooktool_url) {
        this.cooktool_url = cooktool_url;
    }

    public void setCooktool_img(String cooktool_img) {
        this.cooktool_img = cooktool_img;
    }
}
