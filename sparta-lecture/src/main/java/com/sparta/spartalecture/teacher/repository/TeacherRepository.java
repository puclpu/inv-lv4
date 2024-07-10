package com.sparta.spartalecture.teacher.repository;

import com.sparta.spartalecture.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByPhone(String phone);
}
