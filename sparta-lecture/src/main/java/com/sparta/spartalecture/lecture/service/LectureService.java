package com.sparta.spartalecture.lecture.service;

import com.sparta.spartalecture.global.exception.CustomException;
import com.sparta.spartalecture.global.exception.CustomExceptionCode;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.dto.LectureInfoResponseDto;
import com.sparta.spartalecture.lecture.dto.LectureRegistrationRequestDto;
import com.sparta.spartalecture.lecture.dto.LectureRegistrationResponseDto;
import com.sparta.spartalecture.lecture.repository.LectureRepository;
import com.sparta.spartalecture.teacher.domain.Teacher;
import com.sparta.spartalecture.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;

    public LectureRegistrationResponseDto registerLecture(LectureRegistrationRequestDto requestDto) {

        // 강사 존재 여부 확인
        Teacher teacher = findTeacher(requestDto.getTeacherId());

        Lecture newLecture = Lecture.of(requestDto, teacher);
        lectureRepository.save(newLecture);

        return LectureRegistrationResponseDto.from(newLecture);
    }

    public LectureInfoResponseDto getLecture(Long lectureId) {
        Lecture lecture = findLecture(lectureId);
        return LectureInfoResponseDto.from(lecture);
    }

    private Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.LECTURE_NOT_FOUND));
    }

    private Teacher findTeacher (Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.TEACHER_NOT_FOUND));
    }
}
