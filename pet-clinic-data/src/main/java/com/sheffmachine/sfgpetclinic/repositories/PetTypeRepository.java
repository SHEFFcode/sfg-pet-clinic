package com.sheffmachine.sfgpetclinic.repositories;

import com.sheffmachine.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
