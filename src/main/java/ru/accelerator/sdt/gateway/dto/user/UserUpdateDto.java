package ru.accelerator.sdt.gateway.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Integer version;
}
