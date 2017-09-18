package io.app.demo.demo.web;

import io.app.demo.demo.business.services.AnimalService;
import io.app.demo.demo.data.Animal;
import io.app.demo.demo.util.data.ResponseMessage;
import io.app.demo.demo.util.rest.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fidelvillanuevadelgado on 16/09/17.
 */
@RestController
@RequestMapping(value = "/animal")
public class AnimalRestService {

    private AnimalService animalService;

    @Autowired
    public AnimalRestService(AnimalService animalService) {
        this.animalService = animalService;
    }

    /**
     *
     * @return List<Animal>
     */
    @RequestMapping(value = "allAnimals", method = RequestMethod.GET)
    public @ResponseBody  List<Animal> getAllAnimals(){
        return this.animalService.getAllAnimal();
    }

    /**
     *
     * @param animal
     */
    @RequestMapping(value="saveAnimal", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Response saveAnimal(@RequestBody Animal animal){
        this.animalService.saveAnimal(animal);
        return new Response(ResponseMessage.CREATED_OBJECT,HttpStatus.CREATED, Animal.class);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getAnimal/{id}", method = RequestMethod.GET)
    public Animal getAnimal(@PathVariable("id") long id){
        return this.animalService.getAnimal(id);
    }

    /**
     *
     * @param pageable
     * @return
     */
    @RequestMapping(value = "getAnimals", method = RequestMethod.GET)
    public Page<Animal> listAnimal(Pageable pageable){
        return this.animalService.listAllPage(pageable);
    }

    /**
     *
     * @param animal
     */
    @RequestMapping(value = "deleteAnimal", method = RequestMethod.DELETE)
    public @ResponseBody Response deleteAnimal(@RequestBody Animal animal){
        this.animalService.deleteAnimal(animal);
        return new Response(ResponseMessage.DELETE_OBJECT,HttpStatus.OK,Animal.class);
    }

    /**
     *
     * @param animal
     */
    @RequestMapping(value = "updateAnimal", method = RequestMethod.PUT)
    public @ResponseBody Response updateAnimal(@RequestBody  Animal animal){
        this.animalService.updateAnimal(animal);
        return new Response(ResponseMessage.UPDATE_OBJECT,HttpStatus.OK, Animal.class);
    }



}
