package ru.accelerator.sdt.gateway.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.auth.RegisterDto;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserInfoDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;
import ru.accelerator.sdt.gateway.entities.Role;
import ru.accelerator.sdt.gateway.entities.User;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.security.UserDetailsImpl;
import ru.accelerator.sdt.gateway.services.interf.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserInfoDto registerUser(RegisterDto user) {
        User userEntity = User.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .password(passwordEncoder.encode(user.getPassword()))
                .username(user.getUsername())
                .role(Role.valueOf(user.getRole()))
                .dayLimit(100)
                .todayCount(0)
                .build();
        userEntity = userRepository.save(userEntity);
        return UserInfoDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .patronymic(userEntity.getPatronymic())
                .role(userEntity.getRole().name())
                .dayLimit(userEntity.getDayLimit())
                .todayCount(userEntity.getTodayCount())
                .build();
    }

    @Override
    public void updateUser(Integer id, UserUpdateDto userDto) {
        userRepository.updateUser(id , userDto.getVersion(), userDto.getPassword(),
                userDto.getName(), userDto.getSurname(), userDto.getPatronymic());
    }

    @Override
    public UserInfoDto getUserInfo() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication();
        User userEntity = userRepository.findById(userDetails.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        return UserInfoDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .patronymic(userEntity.getPatronymic())
                .role(userEntity.getRole().name())
                .dayLimit(userEntity.getDayLimit())
                .todayCount(userEntity.getTodayCount())
                .build();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
