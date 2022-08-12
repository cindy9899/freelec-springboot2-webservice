package com.jojoldu.book.springboot.web;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    private final Logger LOGGER= LogManager.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(Model model){ //서버 템플릿 안에서 사용할 수 있는 객체를 저장한다.
        //여기서는 postsService.findAllDesc로 가져온 결과를 posts로 index.mustache에 전달한다.
        model.addAttribute("posts", postsService.findAllDesc());
        LOGGER.info("통신="+httpSession);
        LOGGER.info(httpSession.getAttribute("user"));
        SessionUser user= (SessionUser) httpSession.getAttribute("user"); //로그인 성공시에 세션에 SessionUser 저장
        LOGGER.info("유저 정보="+user);
//        model.addAttribute("userName", "연후");
        if(user!=null){ //세션에 저장된 값이 있을 때만 model에 userName으로 등록
            LOGGER.info("null이 아니다!!!!!");
            model.addAttribute("userName", user.getName());
        }
        LOGGER.info("모델="+model);
        return "index"; //앞의 경로는 src/main/resources/templates, 뒤의 확장자는 .mustache로 자동 지정
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}") //수정
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto=postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
