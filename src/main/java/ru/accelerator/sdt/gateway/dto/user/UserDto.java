package ru.accelerator.sdt.gateway.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String username;
    private String dayQueryCount;
    private String todayQueryCount;
    private String role;
}
