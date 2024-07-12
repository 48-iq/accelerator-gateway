package ru.accelerator.sdt.gateway.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String username;
    private String password;
    private Integer dayLimit;
    private Integer todayCount;
    private Integer version;
    private Role role;
}
