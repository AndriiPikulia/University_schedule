package com.schedule.University_schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account", schema = "public")
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
    //use embedded class

    @Column(nullable=false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "accounts_departments",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    private List<Department> departments;

    @ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
    private List<Specialty> specialties;
}
