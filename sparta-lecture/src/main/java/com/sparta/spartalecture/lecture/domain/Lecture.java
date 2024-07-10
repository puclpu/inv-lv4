package com.sparta.spartalecture.lecture.domain;

import com.sparta.spartalecture.lecture.dto.LectureRegistrationRequestDto;
import com.sparta.spartalecture.lecture.type.Category;
import com.sparta.spartalecture.teacher.domain.Teacher;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecture")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Lecture extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "introduce", length = 150, nullable = false)
    private String introduce;

    @Column(name = "category", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public static Lecture of(LectureRegistrationRequestDto requestDto, Teacher teacher) {
        return Lecture.builder()
                .title(requestDto.getTitle())
                .price(requestDto.getPrice())
                .introduce(requestDto.getIntroduce())
                .category(requestDto.getCategory())
                .teacher(teacher)
                .build();
    }
}
