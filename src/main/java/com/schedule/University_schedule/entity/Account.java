package com.schedule.University_schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Relation;

@Setter
@Getter
@Entity
@Table(schema = "Schedule")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, updatable=false)
    private Long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false)
    private String middleName;

    @Column(nullable=false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable=false)
    private Relation department;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

}
