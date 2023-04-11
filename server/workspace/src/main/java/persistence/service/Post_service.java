package persistence.service;

import persistence.dao.Post_dao;
import persistence.dto.Post_dto;
import persistence.MyBatisConnectionFactory;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;

public class Post_service {
    Post_dao post_dao;

    public Post_service(){post_dao = new Post_dao(MyBatisConnectionFactory.getSqlSessionFactory());}

    public List<Post_dto> selectAll(){ // selectAll
        return post_dao.selectAll();
    }
    public List<Post_dto> selectByRegion(int region_id){ // selectByRegion
        return post_dao.selectByRegion(region_id);
    }
    public List<Post_dto> selectByUser(String user_num){ // selectByUser
        return post_dao.selectByPostUser(user_num);
    }
    public List<Post_dto> selectByTitle(String title){ // selectByTitle
        return post_dao.selectByPostTitle(title);
    }
    public boolean insertPost(int user_num, String contents, String title, String dateTime, String region_id){ // insertPost
        Post_dto post_dto = new Post_dto(user_num, contents, title, dateTime, region_id);
        return post_dao.insertPost(post_dto);
    }
    public boolean updatePost(int post_num, String contents, String title){ // updatePost
        Post_dto post_dto = new Post_dto(post_num, contents, title);
        return post_dao.updatePost(post_dto);
    }
    public boolean deletePost(int post_num){ // deletePost
        return post_dao.deletePost(post_num);
    }
}
