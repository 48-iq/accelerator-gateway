package ru.accelerator.sdt.gateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.sdt.gateway.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
