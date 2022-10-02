package com.mozzi.board.toyproj.web.post.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    @DisplayName("메인페이지 로딩")
    public void loadingMainPage() {
        // given

        // when
        String body
                = this.restTemplate.getForObject("/", String.class);
        System.out.println(body);

        // then
        Assertions.assertTrue(body.contains("스프링 부트로 시작하는 웹 서비스"));
    }
}