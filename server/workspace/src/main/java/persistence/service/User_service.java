package persistence.service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.Recipe_dao;
import persistence.dao.User_dao;
import persistence.dto.User_dto;

import java.util.List;

public class User_service {
    User_dao user_dao;
    public User_service(){user_dao = new User_dao(MyBatisConnectionFactory.getSqlSessionFactory());}

    public boolean login(String userId, String userPassword){
        User_dto user_dto = new User_dto();
        user_dto.setUser_id(userId);
        user_dto.setUser_password(userPassword);
        return user_dao.login(user_dto);
    }
    public List<User_dto> selectAll(){ return user_dao.selectAll(); }
    public User_dto selectByUserName(String userName){
        return user_dao.selectByUserName(userName);
    }
    public User_dto selectByUserNum(int userNum){return user_dao.selectByUserNum(userNum);}
    public boolean insertUser(String userId, String userPassword, String userName, String userPhone){
        User_dto userDto = new User_dto(userId, userPassword, userName, userPhone);
        return user_dao.insert(userDto);
    }
}
