package ru.accelerator.sdt.gateway.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserUpdateDto {
    private String name;
    private String surname;
    private String patronymic;
    private String password;
}
