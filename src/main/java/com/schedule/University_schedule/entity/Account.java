package com.schedule.University_schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Relation;

@Setter
@Getter
@Entity
@Table(name="Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, updatable=false)
    private Long id;

    @Column(name = "First name", nullable=false)
    private String firstName;

    @Column(name = "Last name", nullable=false)
    private String lastName;

    @Column(name = "Middle name", nullable=false)
    private String middleName;

    @Column(name = "Email", nullable=false)
    private String email;

    @Column(name = "Department", nullable=false)
    private Relation department;

    @Column(name = "Access level", nullable=false)
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

}
