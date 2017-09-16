package io.app.demo.demo.web;

import io.app.demo.demo.business.services.AnimalService;
import io.app.demo.demo.data.Animal;
import io.app.demo.demo.data.AnimalRepositoryPageable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by marcelvillanuevadelgado on 16/09/17.
 */
@RestController
@RequestMapping(value = "/animal")
@Api(value = "Servicios REST de Animal", description = "Servicios REST de Animal y sus operaciones")
public class AnimalRestService {

    private AnimalService animalService;

    @Autowired
    public AnimalRestService(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ApiOperation(value = "Obtiene el listado de Animales", response = List.class)
    @RequestMapping(value = "allAnimals", method = RequestMethod.GET)
    public @ResponseBody  List<Animal> getAllAnimals(){
        return this.animalService.getAllAnimal();
    }
    @RequestMapping(value="saveAnimal", method = RequestMethod.POST)
    public void saveAnimal(@RequestBody Animal animal){
        this.animalService.saveAnimal(animal);
    }
    @RequestMapping(value = "getAnimal/{id}", method = RequestMethod.GET)
    public Animal getAnimal(@PathVariable("id") long id){
        verifyExist(id);
        return this.animalService.getAnimal(id);
    }
    @RequestMapping(value = "getAnimals", method = RequestMethod.GET)
    public Page<Animal> listAnimal(Pageable pageable){
        return this.animalService.listAllPage(pageable);
    }

    public Animal verifyExist(long id){
        Animal animal=this.animalService.getAnimal(id);
        if (animal==null){
            throw new NoSuchElementException("No se encontró el Animal con el ID: "+id);
        }
        return animal;
    }

}
