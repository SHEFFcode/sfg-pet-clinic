package com.sheffmachine.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private Long id; // use boxed types here, because they can be null, while primitives can not.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
