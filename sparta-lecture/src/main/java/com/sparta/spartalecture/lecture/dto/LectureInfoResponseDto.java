package com.sparta.spartalecture.lecture.dto;

import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.type.Category;
import com.sparta.spartalecture.teacher.dto.TeacherInfoResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LectureInfoResponseDto {

    private Long id;
    private String title;
    private int price;
    private String introduce;
    private Category category;
    private LocalDateTime createdAt;
    private TeacherInfoResponseDto teacher;

    public static LectureInfoResponseDto from(Lecture lecture) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .price(lecture.getPrice())
                .introduce(lecture.getIntroduce())
                .category(lecture.getCategory())
                .createdAt(lecture.getCreatedAt())
                .teacher(TeacherInfoResponseDto.from(lecture.getTeacher()))
                .build();
    }
}
