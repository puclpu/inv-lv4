package com.sparta.spartalecture.lecture.dto;

import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.type.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LectureRegistrationResponseDto {
    private Long id;
    private String title;
    private int price;
    private String introduce;
    private Category category;
    private Long teacherId;
    private LocalDateTime createdAt;

    public static LectureRegistrationResponseDto from(Lecture lecture) {
        return LectureRegistrationResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .price(lecture.getPrice())
                .introduce(lecture.getIntroduce())
                .category(lecture.getCategory())
                .teacherId(lecture.getTeacher().getId())
                .createdAt(lecture.getCreatedAt())
                .build();
    }
}
