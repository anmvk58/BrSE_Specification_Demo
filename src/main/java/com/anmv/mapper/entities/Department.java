package com.anmv.mapper.entities;

import com.anmv.mapper.converter.DepartmentTypeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Department", catalog = "mapper")
@Data
@NoArgsConstructor
public class Department {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "total_member")
    private int totalMember;

    @Column(name = "`type`", nullable = false)
    @Convert(converter = DepartmentTypeConverter.class)
    private Type type;

    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

}
