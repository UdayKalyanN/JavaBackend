package com.example.Library.service.resource;



import com.example.Library.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",message = "Invalid email")
    private String email;
    @NotBlank
    private String role;
    @NotBlank
    @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$",message = "Invalid phone number")
    private String phoneNumber;


    public User toUser(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}