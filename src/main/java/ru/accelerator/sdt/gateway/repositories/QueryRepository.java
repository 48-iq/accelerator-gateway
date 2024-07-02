package ru.accelerator.sdt.gateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.sdt.gateway.entities.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Integer> {
}
