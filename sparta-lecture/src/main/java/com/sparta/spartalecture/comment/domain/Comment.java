package com.sparta.spartalecture.comment.domain;

import com.sparta.spartalecture.comment.dto.CommentCreateRequestDto;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.domain.Timestamped;
import com.sparta.spartalecture.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column(name = "content", nullable = false, length = 150)
    private String content;

    public static Comment of(CommentCreateRequestDto requestDto, Lecture lecture, User user) {
        return Comment.builder()
                .user(user)
                .lecture(lecture)
                .content(requestDto.getContent())
                .build();
    }
}
