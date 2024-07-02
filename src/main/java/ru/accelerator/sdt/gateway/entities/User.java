package ru.accelerator.sdt.gateway.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String dayQueryCount;
    private String todayQueryCount;
    private Integer version;

    @OneToMany(mappedBy = "user")
    private List<Query> queries;

    @OneToMany(mappedBy = "user")
    private List<Area> areas;
}
