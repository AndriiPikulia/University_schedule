package com.schedule.University_schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialty", schema = "public")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String subjects;

    @Column(nullable = false)
    private String fieldOfStudy;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "accounts_specialties",
    joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "specialty_id", referencedColumnName = "id"))
    private List<Account> accounts;

    @ManyToMany(mappedBy = "specialties", fetch = FetchType.LAZY)
    private List<Department> departments;
}
