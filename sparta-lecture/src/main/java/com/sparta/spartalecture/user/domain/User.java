package com.sparta.spartalecture.user.domain;

import com.sparta.spartalecture.comment.domain.Comment;
import com.sparta.spartalecture.like.domain.LikeLecture;
import com.sparta.spartalecture.user.dto.SignupRequestDto;
import com.sparta.spartalecture.user.type.Gender;
import com.sparta.spartalecture.user.type.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", length = 70, unique = true)
    private String email;

    @Column(name = "password", length = 70)
    private String password;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<LikeLecture> likeLectures = new HashSet<>();

    public static User of(SignupRequestDto requestDto, String password) {
        return User.builder()
                .email(requestDto.getEmail())
                .password(password)
                .gender(requestDto.getGender())
                .phone(requestDto.getPhone())
                .address(requestDto.getAddress())
                .role(requestDto.getRole())
                .build();
    }
}
