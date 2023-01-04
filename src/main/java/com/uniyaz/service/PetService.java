package com.uniyaz.service;

import com.uniyaz.dao.PetDao;
import com.uniyaz.domain.Pet;

import java.util.List;

public class PetService {
    public List<Pet> findAll(){
        PetDao petDao = new PetDao();
        return petDao.findAll();
    }

    public Pet save(Pet pet){
        PetDao petDao = new PetDao();
        return petDao.save(pet);
    }

    public void delete(Pet pet){
        PetDao petDao = new PetDao();
        petDao.delete(pet);
    }
}
