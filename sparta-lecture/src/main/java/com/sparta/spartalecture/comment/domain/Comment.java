package com.sparta.spartalecture.comment.domain;

import com.sparta.spartalecture.comment.dto.CommentCreateRequestDto;
import com.sparta.spartalecture.comment.dto.CommentUpdateRequestDto;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.domain.Timestamped;
import com.sparta.spartalecture.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replies = new ArrayList<>();

    public static Comment of(CommentCreateRequestDto requestDto, Lecture lecture, User user) {
        return Comment.builder()
                .user(user)
                .lecture(lecture)
                .content(requestDto.getContent())
                .build();
    }

    public static Comment of(CommentCreateRequestDto requestDto, Comment parentComment, Lecture lecture, User user) {
        return Comment.builder()
                .user(user)
                .lecture(lecture)
                .content(requestDto.getContent())
                .parentComment(parentComment)
                .build();
    }

    public void update(CommentUpdateRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}
