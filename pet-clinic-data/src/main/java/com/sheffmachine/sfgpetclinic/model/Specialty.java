package com.sheffmachine.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "specialties")
public class Specialty extends BaseEntity {
    @Column(name = "description")
    private String description;
}
