package persistence.service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.Reply_dao;
import persistence.dto.Post_dto;
import persistence.dto.Reply_dto;

import java.time.LocalDateTime;
import java.util.List;

public class Reply_service {
    Reply_dao reply_dao;

    public Reply_service(){ reply_dao = new Reply_dao(MyBatisConnectionFactory.getSqlSessionFactory()); }

    public boolean insertFirstReply(int post_num, String user_name, String contents ,String dateTime){
      /*  int reply_seq = 0;

        if (seq == 0) {
            reply_seq = 1;
        } else {
            reply_seq += seq;
        }*/
        Reply_dto replyDto = new Reply_dto(post_num, user_name, contents ,dateTime);
        return reply_dao.insertFirstReply(replyDto);
    }
    public boolean updateReply(int reply_num,String dateTime, String contents){
        Reply_dto replyDto = new Reply_dto(reply_num, dateTime, contents);
        return reply_dao.updateReply(replyDto);
    }

    public boolean deleteReply(int reply_num){
        return reply_dao.deleteReply(reply_num);
    }

}
