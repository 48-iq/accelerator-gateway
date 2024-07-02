package ru.accelerator.sdt.gateway.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin_passwords")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer version;
    private String password;
}
