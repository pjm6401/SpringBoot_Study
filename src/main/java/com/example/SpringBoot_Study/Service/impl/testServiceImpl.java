package com.example.SpringBoot_Study.Service.impl;

import com.example.SpringBoot_Study.DAO.testDAO;
import com.example.SpringBoot_Study.DTO.testDTO;
import com.example.SpringBoot_Study.Entity.testEntity;
import com.example.SpringBoot_Study.Service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testServiceImpl implements testService {
    private final testDAO testDAO;

    @Autowired
    public testServiceImpl(testDAO testDAO){
        this.testDAO = testDAO;
    }
    @Override
    public testDTO get(String id){
        testEntity testEntity = testDAO.select(id);
        testDTO temp = new testDTO();
        temp.setId(testEntity.getId());
        temp.setPw(testEntity.getPw());

        return temp;
    }
    @Override
    public testDTO save(testDTO testDTO){
        testEntity testEntity = new testEntity();
        testEntity.setId(testDTO.getId());
        testEntity.setPw(testDTO.getPw());

        testEntity save = testDAO.insert(testEntity);

        testDTO temp = new testDTO();
        testDTO.setId(save.getId());
        testDTO.setPw(save.getPw());

        return testDTO;
    }
    @Override
    public testDTO update(String id, String pw) throws Exception{
        testEntity update = testDAO.update(id,pw);
        testDTO temp = new testDTO();
        temp.setId(update.getId());
        temp.setPw(update.getPw());
        return temp;
    }
    @Override
    public void delete(String id) throws Exception{
        testDAO.delete(id);
    }
}
