package ru.accelerator.sdt.gateway.services.interf;

import org.springframework.data.domain.Page;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserDto;
import ru.accelerator.sdt.gateway.dto.user.UserRegisterDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;

public interface UserService {
    UserDto registerUser(UserRegisterDto userDto);
    void updateUser(Integer id, UserUpdateDto userDto);
    void updateLimit(Integer id, LimitUpdateDto limitUpdateDto);
    UserDto findUserById(Integer id);
    Page<UserDto> findUsersByUsername(String username, Integer page, Integer size);
    Page<UserDto> findAllUsers(Integer page, Integer size);
    void deleteUserById(Integer id);
}
