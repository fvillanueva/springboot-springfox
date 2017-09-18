package io.app.demo.demo.business.services;

import io.app.demo.demo.data.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by marcelvillanuevadelgado on 16/09/17.
 */
public interface AnimalService {

    Animal getAnimal(long id);
    void saveAnimal(Animal animal);
    void updateAnimal(Animal animal);
    List<Animal> getAllAnimal();
    Page<Animal> listAllPage(Pageable pageable);
    void deleteAnimal(Animal animal);

}
