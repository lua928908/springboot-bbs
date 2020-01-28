package com.study.springboot.springbootbbs.jdbc.dao;

import com.study.springboot.springbootbbs.jdbc.dto.SimpleBbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<SimpleBbsDto> listDao() {
        System.out.println("listDao()");

        String query = "SELECT * FROM bbs ORDER BY ID DESC";
        List<SimpleBbsDto> dtos = template.query( // 리턴값이 여러개면 query 하나면 queryForObject를 사용
                query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class)
        );

        return dtos;
    }

    @Override
    public SimpleBbsDto viewDao(String id){
        System.out.println("viewDao()");
        System.out.println("내가받은 아이디 = "+id);

        String query = "SELECT * FROM bbs WHERE id = " + id;
        SimpleBbsDto dto = template.queryForObject( // 리턴값이 여러개면 query 하나면 queryForObject를 사용
                query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class)
        );

        return dto;
    }

    @Override
    public int writeDao(final String writer, final String title, final String content){
        System.out.println("writeDao()");

        String query = "INSERT INTO bbs (writer, title, content)" + "VALUES (?, ?, ?)";
        return template.update(query, writer, title, content);
    }

    @Override
    public int deleteDao(final String id){
        System.out.println("deleteDao()");

        String query = "DELETE FROM bbs WHERE id = ?";
        return template.update(query, Integer.parseInt(id));
    }
}