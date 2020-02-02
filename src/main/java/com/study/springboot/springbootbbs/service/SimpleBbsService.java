package com.study.springboot.springbootbbs.service;

import com.study.springboot.springbootbbs.dao.ISimpleBbsDao;
import com.study.springboot.springbootbbs.dto.SimpleBbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SimpleBbsService implements ISimpleBbsService {
    @Autowired
    ISimpleBbsDao dao;

    @Override
    public List<SimpleBbsDto> list(){
        return dao.listDao();
    }

    @Override
    public SimpleBbsDto view(String id){
        return dao.viewDao(id);
    }

    @Override
    public int write(Map<String, String> map){
        int nResult = dao.writeDao(map);
        return nResult;
    }

    @Override
    public int delete(String id){
        int nResult = dao.deleteDao(id);
        return nResult;
    }

    @Override
    public int count(){
        int nTotalCount = dao.articleCount();
        return nTotalCount;
    }
}
