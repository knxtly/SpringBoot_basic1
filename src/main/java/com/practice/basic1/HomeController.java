package com.practice.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/home/plus")
    @ResponseBody
    // @ResponseBody: 아래 메서드 실행 후 리턴값을 body에 반응해줘
    public int showPlus(
            // @RequestParam: int a는 쿼리스트링에서 a값을 얻은 후 정수화한 값이다
            @RequestParam(required = false, defaultValue = "1") int a,
            @RequestParam(defaultValue = "0") int b){
        return a * b;
    }
}
