package ru.accelerator.sdt.gateway.services.interf;

import ru.accelerator.sdt.gateway.dto.auth.RegisterDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;

public interface UserValidationService {
    void validateIsCurrentUser(Integer id);
    void validateRegisterDto(RegisterDto user);
    void validateUpdateDto(UserUpdateDto update);
}
