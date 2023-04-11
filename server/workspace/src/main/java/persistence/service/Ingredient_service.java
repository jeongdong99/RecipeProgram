package persistence.service;

import persistence.dao.Ingredient_dao;
import persistence.dto.Ingredient_dto;
import persistence.MyBatisConnectionFactory;

import java.util.ArrayList;
import java.util.List;


public class Ingredient_service {

    Ingredient_dao ingredient_dao;

    public Ingredient_service(){ ingredient_dao = new Ingredient_dao(MyBatisConnectionFactory.getSqlSessionFactory());}

    public List<Integer> selectByIngredientName(String ingName1){
        return ingredient_dao.selectByIngredientName(ingName1);
    }

    public List<Integer> selectByIngredientName(String ingName1, String ingName2){
        return ingredient_dao.selectByIngredientName(ingName1, ingName2);
    }

    public List<Integer> selectByIngredientName(String ingName1, String ingName2, String ingName3){
        return ingredient_dao.selectByIngredientName(ingName1, ingName2, ingName3);
    }
    /*public List<Ingredient_dto> selectByIngredientName(String ingName, String ingName2){
        List<Ingredient_dto> recipe_pk1 = ingredient_dao.selectByIngredientName(ingName);
        List<Ingredient_dto> recipe_pk2 = ingredient_dao.selectByIngredientName(ingName2);
        recipe_pk1.addAll(recipe_pk2);
        return recipe_pk1;
    }
    public List<Ingredient_dto> selectByIngredientName(String ingName, String ingName2, String ingName3){
        List<Ingredient_dto> result_list = new ArrayList<>();
        List<Ingredient_dto> recipe_pk1 = ingredient_dao.selectByIngredientName(ingName);
        List<Ingredient_dto> recipe_pk2 = ingredient_dao.selectByIngredientName(ingName2);
        List<Ingredient_dto> recipe_pk3 = ingredient_dao.selectByIngredientName(ingName3);
        result_list.addAll(recipe_pk1);
        result_list.addAll(recipe_pk2);
        result_list.addAll(recipe_pk3);
        return result_list;
    }*/
}
