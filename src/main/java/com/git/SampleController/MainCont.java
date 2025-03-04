package com.git.SampleController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class MainCont {

    @GetMapping
    public String getWelcome(){
        return "Hello World";
    }

}
