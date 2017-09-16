package io.app.demo.demo.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by marcelvillanuevadelgado on 16/09/17.
 */
@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long>  {


    <S extends Animal> S save(S entity);

    Animal findOne(long aLong);

    Iterable<Animal> findAll();
}
