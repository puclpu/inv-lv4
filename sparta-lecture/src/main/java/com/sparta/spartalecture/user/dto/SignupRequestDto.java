package com.sparta.spartalecture.user.dto;

import com.sparta.spartalecture.user.type.Gender;
import com.sparta.spartalecture.user.type.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignupRequestDto {

    @Email(message = "이메일 형식으로 입력하세요")
    @NotBlank(message = "값이 입력되지 않았습니다")
    private String email;

    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W])).{8,15}+$",
            message = "최소 8자 이상, 15자 이하이며 알파벳 대소문자, 숫자, 특수문자로 구성되어야 합니다")
    @NotBlank(message = "값이 입력되지 않았습니다")
    private String password;

    @NotNull(message = "값이 입력되지 않았습니다")
    private Gender gender;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
            message = "xxx-xxxx-xxxx 형식이어야 합니다.")
    @NotBlank(message = "값이 입력되지 않았습니다")
    private String phone;

    @NotBlank(message = "값이 입력되지 않았습니다")
    private String address;

    @NotNull(message = "값이 입력되지 않았습니다")
    private Role role;
}
