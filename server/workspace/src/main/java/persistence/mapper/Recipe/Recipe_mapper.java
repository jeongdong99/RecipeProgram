package persistence.mapper.Recipe;

import org.apache.ibatis.annotations.*;
import persistence.dao.Recipe_dao;
import persistence.dto.Recipe_dto;
import java.util.List;
import java.util.Map;


public interface Recipe_mapper {

    @SelectProvider(type = Recipe_Sql.class, method = "selectRecipeByName")
    @Results(id = "recipeResultSet", value = {
            @Result(property = "recipe_id", column = "RECIPE_ID"),
            @Result(property = "recipe_name", column = "RECIPE_NAME"),
            @Result(property = "recipe_step", column = "RECIPE_STEP"),
            @Result(property = "recipe_ingredient", column = "RECIPE_INGREDIENT"),
            @Result(property = "recipe_time", column = "RECIPE_TIME"),
            @Result(property = "recipe_level", column = "RECIPE_LEVEL")
    })
    List<Recipe_dto> selectRecipeByName(String name);

    @SelectProvider(type = Recipe_Sql.class, method = "selectRecipeByPK")
    @Results(id = "recipeResultSet2", value= {
            @Result(property = "recipe_id", column = "RECIPE_ID"),
            @Result(property = "recipe_name", column = "RECIPE_NAME"),
            @Result(property = "recipe_step", column = "RECIPE_STEP"),
            @Result(property = "recipe_ingredient", column = "RECIPE_INGREDIENT"),
            @Result(property = "recipe_time", column = "RECIPE_TIME"),
            @Result(property = "recipe_level", column = "RECIPE_LEVEL")
    })
    List<Recipe_dto> selectedRecipeByPK(int pk);

    @SelectProvider(type = Recipe_Sql.class, method = "selectByRecipeTime")
    @Results(id = "recipeResultSet3", value= {
            @Result(property = "recipe_id", column = "RECIPE_ID"),
            @Result(property = "recipe_name", column = "RECIPE_NAME"),
            @Result(property = "recipe_step", column = "RECIPE_STEP"),
            @Result(property = "recipe_ingredient", column = "RECIPE_INGREDIENT"),
            @Result(property = "recipe_time", column = "RECIPE_TIME"),
            @Result(property = "recipe_level", column = "RECIPE_LEVEL")
    })
    List<Recipe_dto> selectByRecipeTime(int time);
}