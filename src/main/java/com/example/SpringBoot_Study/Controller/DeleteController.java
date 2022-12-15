package com.example.SpringBoot_Study.Controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeleteController {
    @DeleteMapping(value = "/delete/{d1}")
    public String d1(@PathVariable String d1){
        return d1;
    }
}
