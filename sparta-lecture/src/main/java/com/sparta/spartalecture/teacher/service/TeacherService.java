package com.sparta.spartalecture.teacher.service;

import com.sparta.spartalecture.teacher.domain.Teacher;
import com.sparta.spartalecture.teacher.dto.TeacherRegistrationRequestDto;
import com.sparta.spartalecture.teacher.dto.TeacherRegistrationResponseDto;
import com.sparta.spartalecture.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherRegistrationResponseDto registerTeacher(TeacherRegistrationRequestDto requestDto) {

        // 이미 존재하는 강사인지 확인
        if (teacherRepository.existsByPhone(requestDto.getPhone())) {
            throw new RuntimeException("이미 존재하는 강사입니다.");
        }

        // 새로운 강사 등록
        Teacher newTeacher = Teacher.from(requestDto);
        teacherRepository.save(newTeacher);

        return TeacherRegistrationResponseDto.from(newTeacher);
    }
}
