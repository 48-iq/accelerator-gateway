package ru.accelerator.sdt.gateway.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserDto;
import ru.accelerator.sdt.gateway.dto.user.UserRegisterDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;
import ru.accelerator.sdt.gateway.entities.User;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.services.interf.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${standard.day.query.count}")
    private final Integer standardDayQueryCount;

    private UserDto userToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .dayQueryCount(user.getDayQueryCount())
                .todayQueryCount(user.getTodayQueryCount())
                .role(user.getRole().name())
                .name(user.getName())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .build();
    }


    @Override
    public UserDto registerUser(UserRegisterDto userDto) {

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .dayQueryCount(standardDayQueryCount)
                .todayQueryCount(0)
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .patronymic(userDto.getPatronymic())
                .version(0)
                .build();

        user = userRepository.save(user);
        return userToDto(user);
    }

    @Override
    public void updateUser(Integer id, Integer version, UserUpdateDto userDto) {
        userRepository.updateUser(id, version, userDto.getPassword(), null, null,
                userDto.getName());
    }

    @Override
    public void updateLimit(Integer id, Integer version, LimitUpdateDto limitUpdateDto) {
        userRepository.updateLimit(id, version,
                limitUpdateDto.getTodayQueryCount(),
                limitUpdateDto.getDayQueryCount());
    }

    @Override
    public UserDto findUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id: " + id + " not found"));
        return userToDto(user);
    }

    @Override
    public Page<UserDto> findUsersByUsername(String username, Integer page, Integer size) {
        Page<User> userPage = userRepository.findUsersByUsername(username, PageRequest.of(page,
                size, Sort.by("username")));
        return new PageImpl<>(userPage.getContent().stream().map(this::userToDto).toList(),
                userPage.getPageable(),
                userPage.getTotalPages());

    }

    @Override
    public Page<UserDto> findAllUsers(Integer page, Integer size) {
        Page<User> userPage = userRepository.findAll(PageRequest.of(page, size));
        return new PageImpl<>(userPage.getContent().stream().map(this::userToDto).toList(),
                userPage.getPageable(),
                userPage.getTotalPages());
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
