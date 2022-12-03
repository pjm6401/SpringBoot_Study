package com.example.SpringBoot_Study.Controller;


import com.example.SpringBoot_Study.DTO.testDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/test1")
public class HelloController {
    // get @PathVariable
    @GetMapping("/hello/{idx}")
    public String hello(@PathVariable("idx") String id){
        System.out.println("Get: "+ LocalDate.now());
        return id;
    }
    // @RequestParam URL에서 ? 를 기준으로 우측에 키 = 값 쌍 형태로 구성된 요청
    @GetMapping("/hello2")
    public String hello2(@RequestParam("id") String idx,
                         @RequestParam String pw){
        System.out.println("Get: "+ LocalDate.now());
        return idx + " : " + pw;
    }

    // Map 을 이용 매개변수의 항목이 일정하지 않을때 효울적
   @GetMapping("/hello3")
    public String hello3(@RequestParam Map<String,String> param){
        System.out.println("Get: "+ LocalDate.now());
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey()+ " : " + map.getValue()+"\n");
        });

        return sb.toString();
    }
    //DTO 객체 hello4?id=park&pw=1234
    @GetMapping("/hello4")
    public String hello4(testDTO testDTO){
        System.out.println("Get: "+ LocalDate.now());
        return testDTO.toString();
    }

}
