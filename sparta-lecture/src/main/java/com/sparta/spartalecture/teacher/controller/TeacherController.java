package com.sparta.spartalecture.teacher.controller;

import com.sparta.spartalecture.teacher.dto.TeacherRegistrationRequestDto;
import com.sparta.spartalecture.teacher.dto.TeacherRegistrationResponseDto;
import com.sparta.spartalecture.teacher.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/admins/teachers")
    public ResponseEntity<TeacherRegistrationResponseDto> registerTeacher(@RequestBody @Valid TeacherRegistrationRequestDto requestDto) {
        TeacherRegistrationResponseDto responseDto = teacherService.registerTeacher(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
