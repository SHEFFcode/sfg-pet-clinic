package com.sheffmachine.sfgpetclinic.springdatajpa;

import com.sheffmachine.sfgpetclinic.model.Owner;
import com.sheffmachine.sfgpetclinic.repositories.OwnerRepository;
import com.sheffmachine.sfgpetclinic.repositories.PetRepository;
import com.sheffmachine.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks // injects the mocks into the constructor and auto wire it
    OwnerJPAService ownerJPAService;
    private final String lastName = "Smith";
    private final Long id = 1L;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(id).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(id).lastName(lastName).build();
        // Below: When ownerRepository.findByLastName is called with anything, return returnOwner.
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownerJPAService.findByLastName(lastName);
        assertEquals(smith, returnOwner);
        verify(ownerRepository, times(1)).findByLastName(any()); // Spy to make sure the method is called
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerJPAService.findById(id);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerJPAService.findById(id);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(id).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerJPAService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());
        // Set up the mock below
        when(ownerRepository.findAll()).thenReturn(returnOwners);
        Set<Owner> owners = ownerJPAService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        ownerJPAService.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(id);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}