package com.sparta.spartalecture.comment.repository;

import com.sparta.spartalecture.comment.domain.Comment;
import com.sparta.spartalecture.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByLectureAndParentCommentIsNull(Lecture lecture);
}
