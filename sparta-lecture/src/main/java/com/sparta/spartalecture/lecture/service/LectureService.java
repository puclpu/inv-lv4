package com.sparta.spartalecture.lecture.service;

import com.sparta.spartalecture.global.exception.CustomException;
import com.sparta.spartalecture.global.exception.CustomExceptionCode;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.dto.LectureInfoByCategoryDto;
import com.sparta.spartalecture.lecture.dto.LectureInfoResponseDto;
import com.sparta.spartalecture.lecture.dto.LectureRegistrationRequestDto;
import com.sparta.spartalecture.lecture.dto.LectureRegistrationResponseDto;
import com.sparta.spartalecture.lecture.repository.LectureRepository;
import com.sparta.spartalecture.lecture.type.Category;
import com.sparta.spartalecture.teacher.domain.Teacher;
import com.sparta.spartalecture.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Page<LectureInfoByCategoryDto> getLecturesByCategory(Category category, int page, int size, String sortBy, boolean isAsc) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Lecture> lectureList = lectureRepository.findAllByCategory(category, pageable);
        return lectureList.map(LectureInfoByCategoryDto::from);
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
