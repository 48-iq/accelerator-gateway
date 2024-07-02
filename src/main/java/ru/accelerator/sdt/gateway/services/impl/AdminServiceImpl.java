package ru.accelerator.sdt.gateway.services.impl;

import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.services.interf.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public String generateAdminPassword() {
        return "";
    }

    @Override
    public Boolean checkAdminPassword(String password) {
        return null;
    }
}
