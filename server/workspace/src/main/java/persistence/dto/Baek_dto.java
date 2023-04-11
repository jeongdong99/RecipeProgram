package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString

public class Baek_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int baek_id;
    private String baek_title;
    private String baek_recipe;
    private String baek_ingredient;
    private String image_url;
    private String video_url;


    public Baek_dto(){}

    public Baek_dto(int baek_id, String baek_title, String baek_recipe, String baek_ingredient, String image_url,String video_url){
        this.baek_id = baek_id;
        this.baek_title = baek_title;
        this.baek_recipe = baek_recipe;
        this.baek_ingredient = baek_ingredient;
        this.image_url = image_url;
        this.video_url = video_url;
    }

    public int getBaek_id() {
        return baek_id;
    }

    public String getBaek_title() {
        return baek_title;
    }

    public String getBaek_recipe() {
        return baek_recipe;
    }

    public String getBaek_ingredient() {
        return baek_ingredient;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setBaek_id(int baek_id) {
        this.baek_id = baek_id;
    }

    public void setBaek_title(String baek_title) {
        this.baek_title = baek_title;
    }

    public void setBaek_recipe(String baek_recipe) {
        this.baek_recipe = baek_recipe;
    }

    public void setBaek_ingredient(String baek_ingredient) {
        this.baek_ingredient = baek_ingredient;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
