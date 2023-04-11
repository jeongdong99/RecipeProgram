package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Post_dto;
import persistence.mapper.Recipe.Ingredient_mapper;
import java.util.Date;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Post_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Post_dao(SqlSessionFactory sqlSessionFactory){this.sqlSessionFactory = sqlSessionFactory;}

    public List<Post_dto> selectAll(){
        List<Post_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.PostMapper.selectAll");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }
    public List<Post_dto> selectByRegion(int region_code){
        List<Post_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.PostMapper.selectByRegion", region_code);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }
    public List<Post_dto> selectByPostUser(String user_name){
        List<Post_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.PostMapper.selectByUser", user_name);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }
    public List<Post_dto> selectByPostTitle(String title){
        List<Post_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.PostMapper.selectByTitle", title);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }
    public boolean insertPost(Post_dto post_dto){
        boolean created = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isCreated = session.insert("mapper.PostMapper.insertPost", post_dto);

        if(isCreated>0){
            session.commit();
            created = true;
        }else{
            session.rollback();
        }
        session.close();

        return created;
    }

    public boolean updatePost(Post_dto post_dto){
        boolean updated = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isUpdated = session.update("mapper.PostMapper.updatePost", post_dto);

        if(isUpdated>0){
            session.commit();
            updated = true;
        }else{
            session.rollback();
        }
        session.close();

        return updated;
    }
    public boolean deletePost(int post_num){
        boolean deleted = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isDeleted = session.delete("mapper.PostMapper.deletePost", post_num);

        if(isDeleted>0){
            session.commit();
            deleted = true;
        }else{
            session.rollback();
        }
        session.close();

        return deleted;
    }
}
