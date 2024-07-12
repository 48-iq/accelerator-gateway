package ru.accelerator.sdt.gateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.entities.Role;
import ru.accelerator.sdt.gateway.entities.User;
import ru.accelerator.sdt.gateway.exceptions.ValidationException;
import ru.accelerator.sdt.gateway.repositories.AdminPasswordRepository;
import ru.accelerator.sdt.gateway.security.UserDetailsImpl;
import ru.accelerator.sdt.gateway.services.interf.AdminValidationService;

@Service
@RequiredArgsConstructor
public class AdminValidationServiceImpl implements AdminValidationService {

    private AdminPasswordRepository adminPasswordRepository;

    @Override
    public void validateLimit(LimitUpdateDto update) {
        if (update.getDayLimit() < 0) throw new ValidationException("day limit must be >= 0");
        if (update.getTodayCount() < 0) throw new ValidationException("today count must be >= 0");
        if (update.getTodayCount() > update.getDayLimit()) throw new ValidationException("today count must be <= day limit");
    }

    @Override
    public void validateIsAdmin() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication();
        User user = userDetails.getUser();
        if (user.getRole() != Role.ADMIN)
            throw new ValidationException("user is not admin");
    }

    @Override
    public void validateAdminPassword(String password) {
        if (!adminPasswordRepository.existsByPassword(password))
            throw new ValidationException("admin password doesn't exist");
    }
}
