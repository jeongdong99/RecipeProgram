package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Recipe_dto;
import persistence.dto.Reply_dto;


import java.util.List;

public class Reply_dao {
    private SqlSessionFactory sqlSessionFactory = null;

    public Reply_dao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

//    public List<Reply_dto> insertReply(String contents, String user_name, int seq, String parent, int depth){
//        List<Reply_dto> list = null;
//
//        SqlSession session = sqlSessionFactory.openSession();
//
//        Reply_dto reply = new Reply_dto();
//
//        try{
//            list = session.selectList("mapper.ReplyMapper.selectByPostNum");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        return list;
//    }


    public boolean insertFirstReply(Reply_dto reply_dto) {
        boolean created = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isCreated = session.insert("mapper.ReplyMapper.insert", reply_dto);

        if(isCreated>0){
            session.commit();
            created = true;
        }else{
            session.rollback();
        }
        session.close();

        return created;
    }

    public boolean updateReply(Reply_dto reply_dto){
        boolean updated = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isUpdated = session.update("mapper.ReplyMapper.update", reply_dto);

        if(isUpdated>0){
            session.commit();
            updated = true;
        }else{
            session.rollback();
        }
        session.close();

        return updated;
    }

    public boolean deleteReply(int reply_num){
        boolean deleted = false;
        SqlSession session = sqlSessionFactory.openSession();
        int isDeleted = session.delete("mapper.ReplyMapper.delete",reply_num);

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
