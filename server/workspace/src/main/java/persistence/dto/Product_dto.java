package persistence.dto;

import java.io.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Product_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int product_id;
    private String product_name;
    private String product_price;
    private String product_url;
    private String product_img;

    public Product_dto(){}

    public Product_dto(int product_id, String product_name, String product_price, String product_url, String product_img){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_url = product_url;
        this.product_img = product_img;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }
}
