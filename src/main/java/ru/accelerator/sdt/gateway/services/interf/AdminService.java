package ru.accelerator.sdt.gateway.services.interf;

import org.springframework.data.domain.Page;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserInfoDto;

public interface AdminService {
    String generateAdminPassword();
    UserInfoDto getUserInfo(Integer id);
    Page<UserInfoDto> getAllUsersInfo(Integer page, Integer size);
    void updateLimit(Integer id, LimitUpdateDto update);
    void deleteUser(Integer id);
}
