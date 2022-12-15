package com.example.SpringBoot_Study.DAO.impl;

import com.example.SpringBoot_Study.DAO.testDAO;
import com.example.SpringBoot_Study.Entity.testEntity;
import com.example.SpringBoot_Study.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class testDAOImpl implements testDAO {

    private final TestRepository testRepository;
    @Autowired
    public testDAOImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @Override
    public testEntity insert(testEntity t){
        testEntity saveEntity = testRepository.save(t);

        return saveEntity;
    }
    @Override
    public testEntity select(String id){
        testEntity selectEntity = testRepository.getReferenceById(id);

        return selectEntity;
    }
    @Override
    public testEntity update(String id, String pw) throws Exception{
        Optional<testEntity> selectEntity = testRepository.findById(id);

        testEntity update;
        if(selectEntity.isPresent()){
            testEntity temp = selectEntity.get();

            temp.setId(id);
            temp.setPw(pw);

            update = testRepository.save(temp);
        }else{
            throw new Exception();
        }

        return update;
    }

    @Override
    public void delete(String id) throws Exception {
        Optional<testEntity> selectEntity = testRepository.findById(id);

        if(selectEntity.isPresent()){
            testEntity delete = selectEntity.get();

            testRepository.delete(delete);
        }else {
            throw new Exception();
        }
    }

}
