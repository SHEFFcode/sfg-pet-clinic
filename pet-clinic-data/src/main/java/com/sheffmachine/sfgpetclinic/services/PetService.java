package com.sheffmachine.sfgpetclinic.services;

import com.sheffmachine.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
