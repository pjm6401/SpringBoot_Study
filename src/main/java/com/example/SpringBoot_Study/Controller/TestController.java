package com.example.SpringBoot_Study.Controller;


import com.example.SpringBoot_Study.DTO.testDTO;
import com.example.SpringBoot_Study.Service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    private final testService testService;

    @Autowired
    public TestController(testService testService){
        this.testService = testService;
    }

    @GetMapping()
    public ResponseEntity<testDTO> get(String id){
        testDTO testDTO = testService.get(id);

        return ResponseEntity.status(HttpStatus.OK).body(testDTO);
    }
    @PostMapping()
    public ResponseEntity<testDTO> create(@RequestBody testDTO testDTO){
        testDTO save = testService.save(testDTO);

        return ResponseEntity.status(HttpStatus.OK).body(save);
    }
    @PutMapping()
    public ResponseEntity<testDTO> put(@RequestBody testDTO testDTO) throws Exception{
        testDTO update = testService.update(testDTO.getId(),testDTO.getPw());

        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
    @DeleteMapping()
    public ResponseEntity<String> delete(String id) throws Exception{
        testService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }
}
