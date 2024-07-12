package ru.accelerator.sdt.gateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.auth.RegisterDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;
import ru.accelerator.sdt.gateway.exceptions.ValidationException;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.security.UserDetailsImpl;
import ru.accelerator.sdt.gateway.services.interf.UserValidationService;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {
    private final UserRepository userRepository;
    @Override
    public void validateIsCurrentUser(Integer id) {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication();
        if (!user.getUser().getId().equals(id))
            throw new ValidationException("this user is not current");
    }

    @Override
    public void validateRegisterDto(RegisterDto user) {
        if (userRepository.existsByUsername(user.getUsername()))
            throw new ValidationException("username already taken");
        if (user.getPassword().length() < 8)
            throw new ValidationException("password is too short");
        if (user.getUsername().length() < 3)
            throw new ValidationException("username is too short");
        if (user.getRole() != "ADMIN" && user.getRole() != "USER")
            throw new ValidationException("set correct role USER or ADMIN");
    }

    @Override
    public void validateUpdateDto(UserUpdateDto user) {
        if (user.getPassword().length() < 8)
            throw new ValidationException("password is too short");
    }
}
