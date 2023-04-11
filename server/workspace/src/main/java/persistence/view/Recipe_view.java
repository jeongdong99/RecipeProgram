package persistence.view;

import persistence.dto.Recipe_dto;
import persistence.service.Recipe_service;

public class Recipe_view {
    Recipe_service recipe_service;
    public Recipe_view(){ recipe_service = new Recipe_service();}

    public void printAll(Recipe_dto recipe_dto){
        System.out.println(recipe_dto.toString());
    }

}
