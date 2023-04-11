package persistence.service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.Baek_dao;
import persistence.dao.Product_dao;
import persistence.dto.Product_dto;
import persistence.dto.Recipe_dto;

import java.util.List;

public class Product_service{
    Product_dao product_dao;

    public Product_service(){ product_dao = new Product_dao(MyBatisConnectionFactory.getSqlSessionFactory()); }

    public List<Product_dto> selectAll(){
        return product_dao.selectAll();
    }

    public List<Product_dto> selectByProductName(String name){
        return product_dao.selectByProductName(name);
    }

    public List<Product_dto>  selectByRelatedRecipe(String ingredient){
        return product_dao.selectByRelatedRecipe(ingredient);
    }

    public List<Product_dto>  selectByCheapProduct(String name){
        return product_dao.selectByCheapProduct(name);
    }




}
