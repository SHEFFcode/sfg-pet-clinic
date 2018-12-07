package com.sheffmachine.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // use boxed types here, because they can be null, while primitives can not.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
