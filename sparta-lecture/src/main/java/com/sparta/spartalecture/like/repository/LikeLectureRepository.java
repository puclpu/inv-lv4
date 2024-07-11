package com.sparta.spartalecture.like.repository;

import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.like.domain.LikeLecture;
import com.sparta.spartalecture.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeLectureRepository extends JpaRepository<LikeLecture, Long> {
    int countByLecture(Lecture lecture);

    Optional<LikeLecture> findByUserAndLecture(User user, Lecture lecture);
}
