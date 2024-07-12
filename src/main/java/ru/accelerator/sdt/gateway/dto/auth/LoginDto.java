package ru.accelerator.sdt.gateway.dto.auth;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {
    private String username;
    private String password;
}
