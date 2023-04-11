package persistence.mapper.Recipe;

import org.apache.ibatis.jdbc.SQL;
import java.util.regex.Matcher;

public class Recipe_Sql {

        public String selectRecipeByName(String name) {
            SQL sql = new SQL() {{
                SELECT("*"); // ID,TITLE, BODY넣기
                FROM("RECIPE"); // FT_ARTICLE넣기
                WHERE("RECIPE_NAME LIKE '%' #{name} '%'");

                //WHERE MATCH(Recipe_name) AGAINST("name"); // MATCH랑 AGAINST넣기
            }};
            return sql.toString();
        }

        public String selectRecipeByPK(int recipePK){
            SQL sql = new SQL(){{
                SELECT("*");
                FROM("RECIPE");
                WHERE("RECIPE_ID = #{recipePK}");
            }};
            return sql.toString();
        }

    public String selectByRecipeTime(int time){
        SQL sql = new SQL(){{
            SELECT("*");
            FROM("RECIPE");
            WHERE("RECIPE_TIME < #{time}");
        }};
        return sql.toString();
    }

}
