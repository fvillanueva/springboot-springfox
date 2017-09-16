package io.app.demo.demo.business.services.impl;

import io.app.demo.demo.business.services.AnimalService;
import io.app.demo.demo.data.Animal;
import io.app.demo.demo.data.AnimalRepository;
import io.app.demo.demo.data.AnimalRepositoryPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelvillanuevadelgado on 16/09/17.
 */
@Service
public class AnimalServiceData implements AnimalService {

    private AnimalRepository animalRepository;
    private AnimalRepositoryPageable animalRepositoryPageable;

    @Autowired
    public AnimalServiceData(AnimalRepository animalRepository, AnimalRepositoryPageable animalRepositoryPageable) {
        this.animalRepository = animalRepository;
        this.animalRepositoryPageable=animalRepositoryPageable;
    }

    @Override
    public Animal getAnimal(long id) {
        return this.animalRepository.findOne(id);
    }

    @Override
    public void saveAnimal(Animal animal) {
        this.animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAllAnimal() {
        List<Animal> animales=new ArrayList<>();
        Iterable<Animal> animals=this.animalRepository.findAll();
        animals.forEach(animal -> {
            Animal an=new Animal();
            an.setName(animal.getName());
            an.setAge(animal.getAge());
            animales.add(an);
        });
        return animales;
    }

    @Override
    public Page<Animal> listAllPage(Pageable pageable) {
        return this.animalRepositoryPageable.findAll(pageable);
    }
}
