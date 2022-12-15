package com.example.SpringBoot_Study.Controller;


import com.example.SpringBoot_Study.DTO.testDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {
    @PostMapping(value = "/post1")
    public String post1(){
        return "Post API";
    }
    @PostMapping(value = "/post2")
    public String post2(@RequestBody testDTO testDTO){
        return testDTO.toString();
    }

}
