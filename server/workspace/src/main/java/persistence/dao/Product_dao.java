package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Post_dto;
import persistence.dto.Product_dto;
import persistence.mapper.Product.Product_mapper;
import persistence.mapper.Recipe.Ingredient_mapper;

import java.util.List;

public class Product_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Product_dao(SqlSessionFactory sqlSessionFactory){ this.sqlSessionFactory = sqlSessionFactory; }

    public List<Product_dto> selectAll(){
        List<Product_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.ProductMapper.selectAll");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }

    public List<Product_dto> selectByProductName(String name){
        List<Product_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.ProductMapper.selectByProductName", name);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }

    public List<Product_dto> selectByCheapProduct(String name){
        List<Product_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.ProductMapper.selectByCheapProduct", name);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }

    public List<Product_dto> selectByRelatedRecipe(String ingredient){
        List<Product_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.ProductMapper.selectByRelatedRecipe", ingredient);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }

}
