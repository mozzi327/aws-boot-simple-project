package com.mozzi.board.toyproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToyProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyProjApplication.class, args);
    }

}
