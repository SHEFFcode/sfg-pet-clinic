package com.sheffmachine.sfgpetclinic.services;

import com.sheffmachine.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Set;
@Service
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
