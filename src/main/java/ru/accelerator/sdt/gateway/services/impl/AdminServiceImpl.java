package ru.accelerator.sdt.gateway.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.user.LimitUpdateDto;
import ru.accelerator.sdt.gateway.dto.user.UserInfoDto;
import ru.accelerator.sdt.gateway.entities.AdminPassword;
import ru.accelerator.sdt.gateway.entities.User;
import ru.accelerator.sdt.gateway.repositories.AdminPasswordRepository;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.services.interf.AdminService;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final Random random = new Random();
    private final AdminPasswordRepository adminPasswordRepository;
    private final UserRepository userRepository;

    private UserInfoDto userToInfoDto(User user) {
        return UserInfoDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .version(user.getVersion())
                .dayLimit(user.getDayLimit())
                .todayCount(user.getTodayCount())
                .build();
    }

    @Override
    @Transactional
    public String generateAdminPassword() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++)
            builder.append(ALPHABET.charAt(random.nextInt() % ALPHABET.length()));
        String password = builder.toString();
        adminPasswordRepository.save(AdminPassword.of(password));
        return password;
    }

    @Override
    public UserInfoDto getUserInfo(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id = " + id + " doesn't exist"));
        return userToInfoDto(user);
    }

    @Override
    public Page<UserInfoDto> getAllUsersInfo(Integer page, Integer size) {
        Page<User> users = userRepository.findAll(PageRequest.of(page, size));
        return users.map(this::userToInfoDto);
    }

    @Override
    @Transactional
    public void updateLimit(Integer id, LimitUpdateDto update) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id = " + id + " doesn't exist"));
        user.setDayLimit(update.getDayLimit());
        user.setTodayCount(user.getTodayCount());
        userRepository.flush();
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
