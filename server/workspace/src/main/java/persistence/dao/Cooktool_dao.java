package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Cooktool_dto;
import persistence.dto.Product_dto;

import java.util.List;

public class Cooktool_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Cooktool_dao(SqlSessionFactory sqlSessionFactory){ this.sqlSessionFactory = sqlSessionFactory; }


    public List<Cooktool_dto> selectByRandomCooktool(){
        List<Cooktool_dto> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try{
            list = session.selectList("mapper.CooktoolMapper.selectByRandomCooktool");
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }
        return list;
    }


}
