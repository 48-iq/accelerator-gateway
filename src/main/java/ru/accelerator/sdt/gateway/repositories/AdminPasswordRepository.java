package ru.accelerator.sdt.gateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.sdt.gateway.entities.AdminPassword;

@Repository
public interface AdminPasswordRepository extends JpaRepository<AdminPassword, Integer> {
    boolean existsByPassword(String password);

}
