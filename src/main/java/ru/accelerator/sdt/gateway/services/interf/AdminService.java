package ru.accelerator.sdt.gateway.services.interf;

public interface AdminService {
    String generateAdminPassword();
    Boolean checkAdminPassword(String password);
}
