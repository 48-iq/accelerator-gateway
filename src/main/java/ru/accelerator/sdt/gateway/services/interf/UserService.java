package ru.accelerator.sdt.gateway.services.interf;

import org.springframework.data.domain.Page;
import ru.accelerator.sdt.gateway.dto.auth.RegisterDto;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserInfoDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;

public interface UserService {
    UserInfoDto registerUser(RegisterDto user);
    void updateUser(Integer id, UserUpdateDto userDto);
    UserInfoDto getUserInfo();
    void deleteUser(Integer id);

}
