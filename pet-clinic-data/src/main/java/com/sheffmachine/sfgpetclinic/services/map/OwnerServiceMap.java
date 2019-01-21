package com.sheffmachine.sfgpetclinic.services.map;

import com.sheffmachine.sfgpetclinic.model.Owner;
import com.sheffmachine.sfgpetclinic.model.Pet;
import com.sheffmachine.sfgpetclinic.services.OwnerService;
import com.sheffmachine.sfgpetclinic.services.PetService;
import com.sheffmachine.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) { // if petType is null, it is likely no been saved to our map yet.
                        if (pet.getPetType().getId() == null) { // Pet type has not been saved to our map yet.
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) { // has the pet been saved? not the petType here so be careful reading
                        Pet savedPet = petService.save(pet); // if the pet has not been saved yet, save it.
                        pet.setId(savedPet.getId()); // make sure a pet has an id.
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> {
            return owner.getLastName().equalsIgnoreCase(lastName);
        }).findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        //TODO: Imeplement
        return null;
    }
}
