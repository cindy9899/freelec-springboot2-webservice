package com.jojoldu.book.springboot.web;
import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){ //서버 템플릿 안에서 사용할 수 있는 객체를 저장한다.
        //여기서는 postsService.findAllDesc로 가져온 결과를 posts로 index.mustache에 전달한다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; //앞의 경로는 src/main/resources/templates, 뒤의 확장자는 .mustache로 자동 지정
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
