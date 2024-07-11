package com.sparta.spartalecture.comment.dto;

import com.sparta.spartalecture.comment.domain.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentInfoResponseDto {

    private Long commentId;
    private Long userId;
    private Long lectureId;
    private String content;
    private LocalDateTime createdAt;

    public static CommentInfoResponseDto from(Comment comment) {
        return CommentInfoResponseDto.builder()
                .commentId(comment.getId())
                .userId(comment.getUser().getId())
                .lectureId(comment.getLecture().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
