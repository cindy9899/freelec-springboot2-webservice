package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest //(controllers = HelloController.class) //Web(Spring MVC)에 집중(컨트롤러만 사용하기때문에 선언)
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈(bean) 주입
    private MockMvc mvc; //웹 API를 테스트. 스프링 MVC테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) //mvc.perform의 결과를 검증(Header의 status, error core)
                .andExpect(content().string(hello)); //mvc.perform의 결과를 검증. 본문 내용의 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name="hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}

