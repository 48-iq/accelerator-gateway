package ru.accelerator.sdt.gateway.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer dayQueryCount;
    private Integer todayQueryCount;
    private String role;
    @JsonIgnore
    private Integer version;
}
