package persistence.service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.Cooktool_dao;
import persistence.dto.Cooktool_dto;

import java.util.List;

public class Cooktool_service {
    Cooktool_dao cooktool_dao;

    public Cooktool_service(){cooktool_dao = new Cooktool_dao(MyBatisConnectionFactory.getSqlSessionFactory());}

    public List<Cooktool_dto> selectByRandomCooktool(){return cooktool_dao.selectByRandomCooktool();}


}
