package com.sparta.spartalecture.teacher.domain;

import com.sparta.spartalecture.teacher.dto.TeacherRegistrationRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Teacher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @Column(name = "name", length = 5, nullable = false)
    private String name;

    @Column(name = "experience", nullable = false)
    private int experience;

    @Column(name = "company", length = 50, nullable = false)
    private String company;

    @Column(name = "phone", length = 20, nullable = false, unique = true)
    private String phone;

    @Column(name = "introduce", length = 150, nullable = false)
    private String introduce;

    public static Teacher from(TeacherRegistrationRequestDto requestDto) {
        return Teacher.builder()
                .name(requestDto.getName())
                .experience(requestDto.getExperience())
                .company(requestDto.getCompany())
                .phone(requestDto.getPhone())
                .introduce(requestDto.getIntroduce())
                .build();
    }
}
