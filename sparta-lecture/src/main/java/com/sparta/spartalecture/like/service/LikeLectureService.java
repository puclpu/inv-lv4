package com.sparta.spartalecture.like.service;

import com.sparta.spartalecture.global.exception.CustomException;
import com.sparta.spartalecture.global.exception.CustomExceptionCode;
import com.sparta.spartalecture.lecture.domain.Lecture;
import com.sparta.spartalecture.lecture.repository.LectureRepository;
import com.sparta.spartalecture.like.domain.LikeLecture;
import com.sparta.spartalecture.like.repository.LikeLectureRepository;
import com.sparta.spartalecture.security.service.UserDetailsImpl;
import com.sparta.spartalecture.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeLectureService {

    private final LikeLectureRepository likeLectureRepository;
    private final LectureRepository lectureRepository;

    public void toggleLike(Long lectureId, UserDetailsImpl userDetails) {
        Lecture lecture = findLecture(lectureId);
        User user = userDetails.getUser();

        Optional<LikeLecture> optionalLikeLecture = likeLectureRepository.findByUserAndLecture(user, lecture);
        if (optionalLikeLecture.isEmpty()) {
            LikeLecture likeLecture = LikeLecture.of(lecture, user);
            likeLectureRepository.save(likeLecture);
        } else {
            likeLectureRepository.delete(optionalLikeLecture.get());
        }
    }

    private Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.LECTURE_NOT_FOUND));
    }
}
