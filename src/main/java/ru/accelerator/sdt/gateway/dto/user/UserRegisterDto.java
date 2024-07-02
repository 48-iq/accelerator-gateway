package ru.accelerator.sdt.gateway.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRegisterDto {
    private String role;
    private String name;
    private String surname;
    private String patronymic;
    private String username;
    private String password;
    private String adminPassword;
}
