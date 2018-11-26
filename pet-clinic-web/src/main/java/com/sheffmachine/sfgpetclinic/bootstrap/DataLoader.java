package com.sheffmachine.sfgpetclinic.bootstrap;
import com.sheffmachine.sfgpetclinic.model.Owner;
import com.sheffmachine.sfgpetclinic.model.Pet;
import com.sheffmachine.sfgpetclinic.model.PetType;
import com.sheffmachine.sfgpetclinic.model.Vet;
import com.sheffmachine.sfgpetclinic.services.OwnerService;
import com.sheffmachine.sfgpetclinic.services.PetTypeService;
import com.sheffmachine.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Market Street");
        owner1.setCity("San Francisco");
        owner1.setTelephone("12245555555");
        Pet makesPet = new Pet();
        makesPet.setPetType(savedDogPetType);
        makesPet.setOwner(owner1);
        makesPet.setBirthDate(LocalDate.now());
        makesPet.setName("Roscoe");
        owner1.getPets().add(makesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 LaSalle Street");
        owner2.setCity("Chicago");
        owner2.setTelephone("12255555555");
        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Katie");
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sane");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Suzzie");
        vet2.setLastName("Axe");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
