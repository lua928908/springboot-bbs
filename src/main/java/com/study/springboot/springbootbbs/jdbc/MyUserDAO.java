package com.study.springboot.springbootbbs.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MyUserDTO> list(){
        String query = "select * from myuser";
        List<MyUserDTO> list = jdbcTemplate.query(
                query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));

        return list;
    }
}