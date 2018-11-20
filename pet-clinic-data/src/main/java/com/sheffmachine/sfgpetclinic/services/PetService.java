package com.sheffmachine.sfgpetclinic.services;

import com.sheffmachine.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface PetService extends CrudService<Pet, Long> {

}
