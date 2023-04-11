package persistence.service;

import persistence.dao.Baek_dao;
import persistence.dto.Baek_dto;
import persistence.MyBatisConnectionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Baek_service {
    Baek_dao baek_dao;

    public Baek_service(){ baek_dao = new Baek_dao(MyBatisConnectionFactory.getSqlSessionFactory()); }

    public List<Baek_dto> selectAll(){ // selectAll
        return baek_dao.selectAll();
    }
    public List<Baek_dto> selectByTitle(HashMap<String ,Object> hashMap){ // selectByTitle
        return baek_dao.selectByBaekTitle(hashMap);
    }

}
