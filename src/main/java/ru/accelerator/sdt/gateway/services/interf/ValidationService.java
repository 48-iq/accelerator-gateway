package ru.accelerator.sdt.gateway.services.interf;

import ru.accelerator.sdt.gateway.dto.area.AreaCreateDto;
import ru.accelerator.sdt.gateway.dto.area.AreaUpdateDto;
import ru.accelerator.sdt.gateway.dto.query.QueryCreateDto;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserDto;
import ru.accelerator.sdt.gateway.dto.user.UserRegisterDto;
import ru.accelerator.sdt.gateway.dto.user.UserUpdateDto;

public interface ValidationService {
    void checkAdmin(Integer id);
    void checkCurrentUser(Integer id);
    void checkUserCanMakeQuery(UserDto userDto);
    void checkUsernameExist(String username);
    void checkUserCorrect(UserRegisterDto userRegisterDto);
    void checkUserCorrect(UserUpdateDto userUpdateDto);
    void checkLimitCorrect(LimitUpdateDto limitUpdateDto);
    void checkAreaCorrect(AreaCreateDto areaCreateDto);
    void checkAreaCorrect(AreaUpdateDto areaUpdateDto);
    void checkQueryCorrect(QueryCreateDto queryDto);
}
