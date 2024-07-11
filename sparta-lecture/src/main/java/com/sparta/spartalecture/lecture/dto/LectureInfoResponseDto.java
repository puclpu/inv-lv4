package com.sparta.spartalecture.lecture.dto;

import com.sparta.spartalecture.comment.dto.CommentInfoResponseDto;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.type.Category;
import com.sparta.spartalecture.teacher.dto.TeacherInfoResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<CommentInfoResponseDto> commentList;

    public static LectureInfoResponseDto of(Lecture lecture, List<CommentInfoResponseDto> commentList) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .price(lecture.getPrice())
                .introduce(lecture.getIntroduce())
                .category(lecture.getCategory())
                .createdAt(lecture.getCreatedAt())
                .teacher(TeacherInfoResponseDto.from(lecture.getTeacher()))
                .commentList(commentList)
                .build();
    }
}
