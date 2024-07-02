package ru.accelerator.sdt.gateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    
    private User userToEntity(UserRegisterDto userDto) {
        return null;
    }

    @Override
    public UserDto registerUser(UserRegisterDto userDto) {
        return null;
    }

    @Override
    public void updateUser(Integer id, UserUpdateDto userDto) {

    }

    @Override
    public void updateLimit(Integer id, LimitUpdateDto limitUpdateDto) {

    }

    @Override
    public UserDto findUserById(Integer id) {
        return null;
    }

    @Override
    public Page<UserDto> findUsersByUsername(String username, Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<UserDto> findAllUsers(Integer page, Integer size) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }
}
