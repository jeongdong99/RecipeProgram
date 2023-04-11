package persistence.mapper.Product;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import persistence.dto.Product_dto;

import java.util.List;

public interface Product_mapper {
    @SelectProvider(type = Product_Sql.class, method = "selectProductByName")
    @Results(id = "productResultSet", value = {
            @Result(property = "product_id", column = "PRODUCT_ID"),
            @Result(property = "product_name", column = "PRODUCT_NAME"),
            @Result(property = "product_price", column = "PRODUCT_PRICE"),
            @Result(property = "product_url", column = "PRODUCT_URL"),
            @Result(property = "product_img", column = "PRODUCT_IMG"),
    })
    List<Product_dto> selectProductByName(String name);

    @SelectProvider(type = Product_Sql.class, method = "selectByCheapProduct")
    @Results(id = "productAsceResultSet", value = {
            @Result(property = "product_id", column = "PRODUCT_ID"),
            @Result(property = "product_name", column = "PRODUCT_NAME"),
            @Result(property = "product_price", column = "PRODUCT_PRICE"),
            @Result(property = "product_url", column = "PRODUCT_URL"),
            @Result(property = "product_img", column = "PRODUCT_IMG"),
    })
    List<Product_dto> selectByCheapProduct(String name);

    @SelectProvider(type = Product_Sql.class, method = "selectByRelatedRecipe")
    @Results(id = "productRelateResultSet", value = {
            @Result(property = "product_id", column = "PRODUCT_ID"),
            @Result(property = "product_name", column = "PRODUCT_NAME"),
            @Result(property = "product_price", column = "PRODUCT_PRICE"),
            @Result(property = "product_url", column = "PRODUCT_URL"),
            @Result(property = "product_img", column = "PRODUCT_IMG"),
    })
    List<Product_dto> selectByRelatedRecipe(String ingredient);
}
