package persistence.mapper;

import org.apache.ibatis.jdbc.SQL;
import persistence.dto.Recipe_dto;

public class BoardSql { //inner style 이걸더 많이 씀
    public String selectRecipeByName(String name) { //최근 day동안의 기록 다들고옴
        SQL sql = new SQL() {{
            SELECT("*");
            FROM("RECIPE");
            WHERE("recipe_name = #{name}"); //#해줘야됨
        }};
        return sql.toString();
    }
}
