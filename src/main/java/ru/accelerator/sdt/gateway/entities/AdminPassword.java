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
    public static AdminPassword of (String password) {
        return new AdminPassword(null, password);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
}
