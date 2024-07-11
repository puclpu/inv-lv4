package com.sparta.spartalecture.lecture.dto;

import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.type.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LectureInfoByCategoryDto {
    private Long id;
    private String title;
    private int price;
    private String introduce;
    private Category category;
    private LocalDateTime createdAt;
    private Long teacherId;

    public static LectureInfoByCategoryDto from(Lecture lecture) {
        return LectureInfoByCategoryDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .price(lecture.getPrice())
                .introduce(lecture.getIntroduce())
                .category(lecture.getCategory())
                .createdAt(lecture.getCreatedAt())
                .teacherId(lecture.getTeacher().getId())
                .build();
    }
}
