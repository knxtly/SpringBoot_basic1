package com.practice.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    private int count;

    public HomeController(){
        count = -1;
    }

    @GetMapping("/home/increase")
    @ResponseBody
    // @ResponseBody: 아래 메서드 실행 후 리턴값을 응답으로 해줘
    public int showIncrease(){
        ++count;
        return count;
    }
}
