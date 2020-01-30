package com.study.springboot.springbootbbs.jdbc.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.study.springboot.springbootbbs.jdbc.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(String writer, String title, String content);
    public int deleteDao(String id);
}