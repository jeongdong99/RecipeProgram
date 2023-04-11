package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Recipe_dto;
import persistence.mapper.Recipe.Recipe_mapper;

import java.util.HashMap;
import java.util.List;

public class Recipe_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Recipe_dao(SqlSessionFactory sqlSessionFactory){ this.sqlSessionFactory = sqlSessionFactory; }

    public Recipe_dto selectById(int id){
        Recipe_dto recipe_dto = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            recipe_dto = session.selectOne("mapper.RecipeMapper.selectByRecipeId", id);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return recipe_dto;
    }

    public List<Recipe_dto> selectByName(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeName", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }

    public List<Recipe_dto> selectByRecipeLevel(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeLevel", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }

    public List<Recipe_dto> selectByRecipeTime(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeTime", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeTimeAndLevel(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeTimeAndLevel", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeTimeAndIng1(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeTimeAndIng1", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeTimeAndIng2(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeTimeAndIng2", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeTimeAndIng3(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeTimeAndIng3", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeLevelAndIng1(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeLevelAndIng1", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeLevelAndIng2(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeLevelAndIng2", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeLevelAndIng3(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeLevelAndIng3", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeAllOption1(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeAllOption1", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeAllOption2(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeAllOption2", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
    public List<Recipe_dto> selectByRecipeAllOption3(HashMap<String, Object> hashMap){
        List<Recipe_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.RecipeMapper.selectByRecipeAllOption3", hashMap);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }
}