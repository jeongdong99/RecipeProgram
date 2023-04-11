package persistence.service;

import persistence.dao.Recipe_dao;
import persistence.dao.Ingredient_dao;
import persistence.MyBatisConnectionFactory;
import persistence.dto.Ingredient_dto;
import persistence.dto.Recipe_dto;

import java.util.HashMap;
import java.util.List;

public class Recipe_service {
    Recipe_dao recipe_dao;

    public Recipe_service(){recipe_dao = new Recipe_dao(MyBatisConnectionFactory.getSqlSessionFactory());}

    public List<Recipe_dto> selectRecipeByName(HashMap<String, Object> hashMap){
        return recipe_dao.selectByName(hashMap);
    }
    public Recipe_dto selectRecipeById(int id){
        return recipe_dao.selectById(id);
    }

    public List<Recipe_dto> selectRecipeByLevel(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeLevel(hashMap);
    }

    public List<Recipe_dto> selectRecipeByTime(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeTime(hashMap);
    }

    public List<Recipe_dto> selectRecipeByTimeLevel(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeTimeAndLevel(hashMap);
    }
    public List<Recipe_dto> selectRecipeByTimeIng1(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeTimeAndIng1(hashMap);
    }
    public List<Recipe_dto> selectRecipeByTimeIng2(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeTimeAndIng2(hashMap);
    }
    public List<Recipe_dto> selectRecipeByTimeIng3(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeTimeAndIng3(hashMap);
    }
    public List<Recipe_dto> selectRecipeByLevelIng1(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeLevelAndIng1(hashMap);
    }
    public List<Recipe_dto> selectRecipeByLevelIng2(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeLevelAndIng2(hashMap);
    }
    public List<Recipe_dto> selectRecipeByLevelIng3(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeLevelAndIng3(hashMap);
    }
    public List<Recipe_dto> selectRecipeByAllOption1(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeAllOption1(hashMap);
    }
    public List<Recipe_dto> selectRecipeByAllOption2(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeAllOption2(hashMap);
    }
    public List<Recipe_dto> selectRecipeByAllOption3(HashMap<String, Object> hashMap){
        return recipe_dao.selectByRecipeAllOption3(hashMap);
    }
}
