package com.study.springboot.springbootbbs.service;

import com.study.springboot.springbootbbs.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISimpleBbsService {
    public List<SimpleBbsDto> list();
    public SimpleBbsDto view(String id);
    public int write(Map<String, String> map);
    public int delete(@Param("id")String id);
    public int count();
}
