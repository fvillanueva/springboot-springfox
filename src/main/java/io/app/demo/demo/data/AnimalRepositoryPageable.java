package io.app.demo.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by fidelvillanuevadelgado on 16/09/17.
 */
public interface AnimalRepositoryPageable extends PagingAndSortingRepository<Animal, Long> {

}
