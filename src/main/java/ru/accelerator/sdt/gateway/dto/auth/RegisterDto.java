package ru.accelerator.sdt.gateway.dto.auth;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDto {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private String role;
    private String adminPassword;
}
