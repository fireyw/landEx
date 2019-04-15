package com.example.demo.dao;

import com.example.demo.domain.Apt;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Component
public class AptDAO {

    @Autowired
    private SqlSession sqlSession;

    public void saveAptData(List<Apt> aptData) {
        this.sqlSession.insert("com.example.demo.mapper.aptMapper.saveAptData", aptData);
    }

}
