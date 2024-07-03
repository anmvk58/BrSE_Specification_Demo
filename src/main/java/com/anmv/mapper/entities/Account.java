package com.anmv.mapper.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Account", catalog = "mapper")
@Data
@NoArgsConstructor
public class Account {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
