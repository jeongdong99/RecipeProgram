package persistence.dto;

import java.io.*;


public class Ingredient_dto implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;
    private int ingredients_id;
    private int recipe_id;
    private String ingredient_name;

    public Ingredient_dto(int ingredients_id, int recipe_id, String ingredient_name){
        this.ingredients_id = ingredients_id;
        this.recipe_id = recipe_id;
        this.ingredient_name = ingredient_name;
    }

    public int getIngredients_id() {
        return ingredients_id;
    }

    public void setIngredients_id(int ingredients_id) {
        this.ingredients_id = ingredients_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
