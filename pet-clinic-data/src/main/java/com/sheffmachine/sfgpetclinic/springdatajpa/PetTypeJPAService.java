package com.sheffmachine.sfgpetclinic.springdatajpa;

import com.sheffmachine.sfgpetclinic.model.PetType;
import com.sheffmachine.sfgpetclinic.repositories.PetTypeRepository;
import com.sheffmachine.sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

public class PetTypeJPAService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return null;
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
