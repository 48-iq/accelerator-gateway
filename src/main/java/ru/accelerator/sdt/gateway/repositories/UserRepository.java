package ru.accelerator.sdt.gateway.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.accelerator.sdt.gateway.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query(value = "Update [users] " +
            "set    password = coalesce(:password, password)" +
            "set    name = coalesce(:name, name)" +
            "set    surname = coalesce(:surname, surname)" +
            "set    patronymic = coalesce(:patronymic, patronymic)" +
            "set    version = version + 1" +
            "where  id = :id and version = :version",
    nativeQuery = true)
    void updateUser(Integer id,  Integer version, String password, String name, String surname,
                    String patronymic);
    @Modifying
    @Query(value = "Update [users] " +
            "set    password = coalesce(:password, password)" +
            "set    name = coalesce(:name, name)" +
            "set    version = version + 1" +
            "where  id = :id and version = :version",
            nativeQuery = true)
    void updateLimit(Integer id, Integer version, Integer todayQueryCount, Integer dayQueryCount);

    @Query("Select u from User u where u.username = :username")
    Page<User> findUsersByUsername(String username, Pageable pageable);
    boolean existsByUsername(String username);
}
