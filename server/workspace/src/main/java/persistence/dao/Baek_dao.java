package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Baek_dto;

import java.util.HashMap;
import java.util.List;

public class Baek_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Baek_dao(SqlSessionFactory sqlSessionFactory){ this.sqlSessionFactory = sqlSessionFactory; }

    public List<Baek_dto> selectAll(){
        List<Baek_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.BaekMapper.selectAll");
        }catch(Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return list;
    }
    public List<Baek_dto> selectByBaekTitle(HashMap<String, Object> hashMap) {
        List<Baek_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("mapper.BaekMapper.selectByBaekTitle", hashMap);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            session.close();
        }

        return list;
    }
}
