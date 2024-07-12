package ru.accelerator.sdt.gateway.services.interf;

import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;

public interface AdminValidationService {
    void validateLimit(LimitUpdateDto update);
    void validateIsAdmin();
    void validateAdminPassword(String password);
}
