package com.example.demo.service;

import com.example.demo.dao.AptDAO;
import com.example.demo.domain.Apt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AptService {

    @Autowired
    AptDAO aptDAO;

    public void saveAptData(List<Apt> aptData){
        aptDAO.saveAptData(aptData);
    }
}
