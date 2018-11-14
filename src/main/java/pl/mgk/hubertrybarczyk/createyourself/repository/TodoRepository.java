package pl.mgk.hubertrybarczyk.createyourself.repository;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<pl.mgk.hubertrybarczyk.createyourself.model.Todo, Long> {
}
