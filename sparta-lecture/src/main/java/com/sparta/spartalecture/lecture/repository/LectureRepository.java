package com.sparta.spartalecture.lecture.repository;

import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.type.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Page<Lecture> findAllByCategory(Category category, Pageable pageable);
}
