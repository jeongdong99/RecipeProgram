package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.User_dto;

import java.util.List;

public class User_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public User_dao(SqlSessionFactory sqlSessionFactory){ this.sqlSessionFactory = sqlSessionFactory; }

    public boolean login(User_dto user_dto){
        boolean isSuccess = false;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            isSuccess = session.selectOne("mapper.UserMapper.login", user_dto.getUser_id());
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return isSuccess;
    }

    public List<User_dto> selectAll(){
        List<User_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.UserMapper.selectAll");
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }
    public User_dto selectByUserName(String userName){
        User_dto user_dto = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            user_dto = session.selectOne("mapper.UserMapper.selectByUserName", userName);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return user_dto;
    }
    public User_dto selectByUserNum(int userNum){
        User_dto user_dto = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            user_dto = session.selectOne("mapper.UserMapper.selectByUserNum", userNum);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return user_dto;
    }

    public boolean insert(User_dto user_dto){
        boolean created = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isCreated = session.insert("mapper.UserMapper.insert", user_dto);

        if(isCreated>0){
            session.commit();
            created = true;
        }else{
            session.rollback();
        }
        session.close();

        return created;
    }

    public String listToString(List<User_dto> list){
        String result = "";
        for(User_dto o : list){
            result += o.toString()+"\uF04D";
        }
        return result;
    }
}
