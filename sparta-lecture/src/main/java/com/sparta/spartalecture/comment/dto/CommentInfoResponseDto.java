package com.sparta.spartalecture.comment.dto;

import com.sparta.spartalecture.comment.domain.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<CommentInfoResponseDto> replies;

    public static CommentInfoResponseDto from(Comment comment) {

        List<CommentInfoResponseDto> replies = new ArrayList<>();
        for (Comment reply : comment.getReplies()) {
            replies.add(CommentInfoResponseDto.from(reply));
        }

        return CommentInfoResponseDto.builder()
                .commentId(comment.getId())
                .userId(comment.getUser().getId())
                .lectureId(comment.getLecture().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .replies(replies)
                .build();
    }
}
