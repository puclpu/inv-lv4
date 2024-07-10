package com.sparta.spartalecture.lecture.controller;

import com.sparta.spartalecture.lecture.dto.LectureInfoResponseDto;
import com.sparta.spartalecture.lecture.dto.LectureRegistrationRequestDto;
import com.sparta.spartalecture.lecture.dto.LectureRegistrationResponseDto;
import com.sparta.spartalecture.lecture.service.LectureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/admins/lectures")
    public ResponseEntity<LectureRegistrationResponseDto> registerLecture(@RequestBody @Valid LectureRegistrationRequestDto requestDto) {
        LectureRegistrationResponseDto responseDto = lectureService.registerLecture(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/lectures/{lectureId}")
    public ResponseEntity<LectureInfoResponseDto> getLecture(@PathVariable Long lectureId) {
        LectureInfoResponseDto responseDto = lectureService.getLecture(lectureId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
