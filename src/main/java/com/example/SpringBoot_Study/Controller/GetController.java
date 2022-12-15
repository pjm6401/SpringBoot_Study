package com.example.SpringBoot_Study.Controller;
import com.example.SpringBoot_Study.DTO.testDTO;
import com.example.SpringBoot_Study.Entity.testEntity;
import com.example.SpringBoot_Study.Repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GetController {
    // get @PathVariable
    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결한다 즉 new 이렇게 객체를 선언 안해줘도 생성됨
    private TestRepository testRepository;
    @Autowired
    private testEntity testEntity;
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);


    @GetMapping("/get1/{idx}")
    public String hello(@PathVariable("idx") String id){
        System.out.println("Get: "+ LocalDate.now());
        LOGGER.info("hello 메서드 호출 : {} ",id);
        return id;
    }
    // @RequestParam URL에서 ? 를 기준으로 우측에 키 = 값 쌍 형태로 구성된 요청
    @GetMapping("/get2")
    public String hello2(@RequestParam("id") String idx,
                         @RequestParam String pw){
        System.out.println("Get: "+ LocalDate.now());
        return idx + " : " + pw;
    }

    // Map 을 이용 매개변수의 항목이 일정하지 않을때 효울적
   @GetMapping("/get3")
    public String hello3(@RequestParam Map<String,String> param){
        System.out.println("Get: "+ LocalDate.now());
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey()+ " : " + map.getValue()+"\n");
        });

        return sb.toString();
    }
    //DTO 객체 hello4?id=park&pw=1234
    @GetMapping("/get4")
    public String hello4(testDTO testDTO){
        System.out.println("Get: "+ LocalDate.now());
        testEntity.setId(testDTO.getId());
        testEntity.setPw(testDTO.getPw());
        System.out.println(testEntity.toString());
        LOGGER.info("Get 메서드 호출 : {} ",testEntity.toString());
        testRepository.save(testEntity);
        return testDTO.toString();
    }

}
