package com.example.SpringBoot_Study.Controller;

import com.example.SpringBoot_Study.DTO.testDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api")
//리소스 값 업데이트에 사용한다
public class PutController {
    //값 확실하지 않을때
    @PutMapping("/put1")
    public String hello3(@RequestBody Map<String,String> param){
        System.out.println("Get: "+ LocalDate.now());
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey()+ " : " + map.getValue()+"\n");
        });

        return sb.toString();
    }
    @PutMapping("/put2")
    public String hello4(@RequestBody testDTO testDTO){
        testDTO.setId("park");
        testDTO.setPw("1234");
        System.out.println("Get: "+ LocalDate.now());
        return testDTO.toString();
    }
    //httpEntity 헤더와 바디로 구성된 http 요청과 응답 구성
    //RequestEntity, ResponseEntity 는 httpEntity 를 상속받아 구현한 클래스
    //ResponseEntity 는 서버에 들어온 요청에 대해 응답 데이터를 구성해서 전달할 수 있게 한다.
    @PutMapping("/put3")
    public ResponseEntity<testDTO> put(@RequestBody testDTO testDTO){
        System.out.println("Get: "+ LocalDate.now());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(testDTO);
    }

}
