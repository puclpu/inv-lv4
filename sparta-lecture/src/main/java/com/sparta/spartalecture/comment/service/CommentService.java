package com.sparta.spartalecture.comment.service;

import com.sparta.spartalecture.comment.domain.Comment;
import com.sparta.spartalecture.comment.dto.CommentCreateRequestDto;
import com.sparta.spartalecture.comment.dto.CommentUpdateRequestDto;
import com.sparta.spartalecture.comment.repository.CommentRepository;
import com.sparta.spartalecture.global.exception.CustomException;
import com.sparta.spartalecture.global.exception.CustomExceptionCode;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.repository.LectureRepository;
import com.sparta.spartalecture.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final LectureRepository lectureRepository;

    public void createComment(CommentCreateRequestDto requestDto, Long lectureId, UserDetailsImpl userDetails) {
        // 강의 존재 여부 판별
        Lecture lecture = findLecture(lectureId);

        // 댓글 save
        Comment comment = Comment.of(requestDto, lecture,userDetails.getUser());
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(CommentUpdateRequestDto requestDto, Long commentId, UserDetailsImpl userDetails) {
        // 댓글 존재 여부 판별
        Comment comment = findComment(commentId);

        // 동일한 작성자인지 판별
        Long writerId = comment.getUser().getId();
        Long userId = userDetails.getUser().getId();
        if (!writerId.equals(userId)) {
            throw new CustomException(CustomExceptionCode.COMMENT_ACCESS_DENIED);
        }

        // 댓글 수정
        comment.update(requestDto);
    }

    public void deleteComment(Long commentId, UserDetailsImpl userDetails) {
        // 댓글 존재 여부 판별
        Comment comment = findComment(commentId);

        // 동일한 작성자인지 판별
        Long writerId = comment.getUser().getId();
        Long userId = userDetails.getUser().getId();
        if (!writerId.equals(userId)) {
            throw new CustomException(CustomExceptionCode.COMMENT_ACCESS_DENIED);
        }

        commentRepository.delete(comment);
    }

    private Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.LECTURE_NOT_FOUND));
    }

    private Comment findComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.COMMENT_NOT_FOUND));
    }
}
