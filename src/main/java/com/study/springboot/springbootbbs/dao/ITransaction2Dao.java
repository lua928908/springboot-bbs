package com.study.springboot.springbootbbs.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction2Dao {
    public void pay(String consumerId, int amount);
}
