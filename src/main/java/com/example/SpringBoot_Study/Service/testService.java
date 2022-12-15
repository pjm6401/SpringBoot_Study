package com.example.SpringBoot_Study.Service;

import com.example.SpringBoot_Study.DTO.testDTO;

public interface testService {
    testDTO get(String id);
    testDTO save(testDTO testDTO);
    testDTO update(String id, String pw) throws Exception;
    void delete(String id) throws Exception;
}
