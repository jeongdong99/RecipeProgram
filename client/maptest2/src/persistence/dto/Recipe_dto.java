package persistence.dto;

import java.io.*;



public class Recipe_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;
    private int recipe_id;
    private String recipe_name;
    private String recipe_step;
    private String recipe_ingredient;
    private String recipe_time;
    private String recipe_level;
    private String recipe_url;

    public Recipe_dto(){}

    public Recipe_dto(int recipe_id, String recipe_name, String recipe_step, String recipe_ingredient, String recipe_time, String recipe_level, String recipe_url){
        this.recipe_id = recipe_id;
        this.recipe_ingredient = recipe_ingredient;
        this.recipe_name = recipe_name;
        this.recipe_step = recipe_step;
        this.recipe_time = recipe_time;
        this.recipe_level = recipe_level;
        this.recipe_url = recipe_url;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getRecipe_step() {
        return recipe_step;
    }

    public void setRecipe_step(String recipe_step) {
        this.recipe_step = recipe_step;
    }

    public String getRecipe_ingredient() {
        return recipe_ingredient;
    }

    public void setRecipe_ingredient(String recipe_ingredient) {
        this.recipe_ingredient = recipe_ingredient;
    }

    public String getRecipe_time() {
        return recipe_time;
    }

    public void setRecipe_time(String recipe_time) {
        this.recipe_time = recipe_time;
    }

    public String getRecipe_level() {
        return recipe_level;
    }

    public void setRecipe_level(String recipe_level) {
        this.recipe_level = recipe_level;
    }

    public String getRecipe_url() {
        return recipe_url;
    }

    public void setRecipe_url(String recipe_url) {
        this.recipe_url = recipe_url;
    }
}
