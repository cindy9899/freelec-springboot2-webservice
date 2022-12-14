package com.jojoldu.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface PostsRepository extends JpaRepository<Posts, Long>{
    //JpaRepository<Entity 클래스, PK 타입>을 상속하면
    //기본적인 CRUDpo 메소드 자동 생성
    //!!Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
