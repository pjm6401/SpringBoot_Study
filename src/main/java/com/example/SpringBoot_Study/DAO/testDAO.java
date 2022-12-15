package com.example.SpringBoot_Study.DAO;

import com.example.SpringBoot_Study.Entity.testEntity;

public interface testDAO {

    testEntity insert(testEntity testEntity);
    testEntity select(String id);
    testEntity update(String id, String pw) throws Exception;
    void delete(String id) throws Exception;


}
