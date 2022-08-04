package com.jojoldu.book.springboot.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index"; //앞의 경로는 src/main/resources/templates, 뒤의 확장자는 .mustache로 자동 지정
    }
}
