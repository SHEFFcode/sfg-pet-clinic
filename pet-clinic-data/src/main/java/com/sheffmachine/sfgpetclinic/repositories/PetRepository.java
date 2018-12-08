package com.sheffmachine.sfgpetclinic.repositories;

import com.sheffmachine.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
