package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Ingredient_dto;
import persistence.dto.Recipe_dto;
import persistence.mapper.Recipe.Ingredient_mapper;
import persistence.mapper.Recipe.Recipe_mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ingredient_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Ingredient_dao(SqlSessionFactory sqlSessionFactory){ this.sqlSessionFactory = sqlSessionFactory; }

    /*public List<Ingredient_dto> selectByIngredientName(String ingredient_name){
        List<Ingredient_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.IngredientMapper.selectOne", ingredient_name);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }*/

    public List<Integer> selectByIngredientName(String ingName1){
        HashMap<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("ing1", ingName1);
        List<Integer> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.IngredientMapper.selectIngredientByNameOne", ingredients);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }

    public List<Integer> selectByIngredientName(String ingName1, String ingName2){
        HashMap<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("ing1", ingName1);
        ingredients.put("ing2", ingName2);
        List<Integer> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.IngredientMapper.selectIngredientByNameTwo", ingredients);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }

    public List<Integer> selectByIngredientName(String ingName1, String ingName2, String ingName3){
        HashMap<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("ing1", ingName1);
        ingredients.put("ing2", ingName2);
        ingredients.put("ing3", ingName3);
        List<Integer> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.IngredientMapper.selectIngredientByNameThree", ingredients);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }

}
