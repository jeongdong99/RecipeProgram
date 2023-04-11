package persistence.mapper.Cooktool;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import persistence.dto.Product_dto;

import java.util.List;

public interface Cooktool_mapper {
    @SelectProvider(type = Cooktool_Sql.class, method = "selectCooktoolByName")
    @Results(id = "cooktoolResultSet", value = {
            @Result(property = "cooktool_id", column = "COOKTOOL_ID"),
            @Result(property = "cooktool_name", column = "COOKTOOL_NAME"),
            @Result(property = "cooktool_price", column = "COOKTOOL_PRICE"),
            @Result(property = "cooktool_url", column = "COOKTOOL_URL"),
            @Result(property = "cooktool_img", column = "COOKTOOL_IMG"),
    })
    List<Product_dto> selectProductByName(String name);
//나중에 하자~
}
