package persistence.mapper.Recipe;

import org.apache.ibatis.jdbc.SQL;

public class Ingredient_Sql {
    public String selectByIngredientName(String ingName){
        SQL sql = new SQL(){{
            SELECT("recipe_id");
            FROM("ingredients");
            WHERE("ingredient_name = #{ingName}");
        }};
        return sql.toString();
    }
}
