package com.sparta.spartalecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaLectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaLectureApplication.class, args);
    }

}
