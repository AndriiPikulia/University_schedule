package com.schedule.University_schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "Schedule")
public class Specialities {
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

    //    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "account"),
//    joinColumns = @JoinColumn(name = "account_id",
//            referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id"))
//    private List <Speciality> specialities;

}
