package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만듬
public class HelloController {

    @GetMapping("/hello") //GET 요청을 받을 수 있는 API를 만듬
    public String hello(){
        return "hello"; //hello 요청이 오면 hello라는 문자열을 반환
    }
}
