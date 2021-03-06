package com.study.springboot.springbootbbs.dao;

import java.util.List;
import java.util.Map;

import com.study.springboot.springbootbbs.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ISimpleBbsDao {
    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(Map<String, String> map);
    public int deleteDao(@Param("id") String id);
    public int articleCount();
}