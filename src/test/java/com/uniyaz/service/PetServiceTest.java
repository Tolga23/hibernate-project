package com.uniyaz.service;

import com.uniyaz.domain.Pet;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class PetServiceTest {

    @Test
    public void findAllTest() {
        PetService petService = new PetService();
        List<Pet> petList = petService.findAll();
        for (Pet pet : petList) {
            System.out.println(pet);
        }
    }

    @Test
    public void insertTest(){
        Pet pet = new Pet();
        pet.setType("Cat");
        pet.setWeight(new BigDecimal(7.23));
        pet.setBornDate(new java.util.Date());

        PetService petService = new PetService();
        pet = petService.save(pet);

        System.out.println(pet);
    }

    @Test
    public void deleteTest(){
        Pet pet = new Pet();
        pet.setId(1L);

        PetService petService = new PetService();
        petService.delete(pet);

        System.out.println("Kayıt Silindi");
    }


}
