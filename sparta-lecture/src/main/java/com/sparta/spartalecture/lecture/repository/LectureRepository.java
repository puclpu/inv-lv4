package com.sparta.spartalecture.lecture.repository;

import com.sparta.spartalecture.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
