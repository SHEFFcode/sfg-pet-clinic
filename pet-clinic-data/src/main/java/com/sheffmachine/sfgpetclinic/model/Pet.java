package com.sheffmachine.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Builder
    public Pet(Long id, PetType petType, Owner owner, LocalDate birthDate, Long id1, String name, Set<Visit> visits) {
        super(id);
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.id = id1;
        this.name = name;
        this.visits = visits;
    }

    public Pet(PetType petType, Owner owner, LocalDate birthDate, Long id, String name, Set<Visit> visits) {
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.id = id;
        this.name = name;
        this.visits = visits;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
