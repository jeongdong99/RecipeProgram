package persistence.mapper.Recipe;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface Ingredient_mapper {
    @SelectProvider(type = Ingredient_Sql.class, method="selectByIngredientName")
    @Result(property = "recipe_id", column = "RECIPE_ID")
    List<Integer> selectedByIngredientName(String name);
}
//SELECT * FROM mydb.ingredients WHERE ingredient_name="돼지고기" AND recipe_id in ( SELECT recipe_id FROM mydb.ingredients WHERE ingredient_name="고구마");