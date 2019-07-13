package pl.mgk.hubertrybarczyk.createyourself.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;

import java.util.Set;

public interface TodoRepository extends CrudRepository<pl.mgk.hubertrybarczyk.createyourself.model.Todo, Long> {
    Set<Todo> findAllByObjective(Objective objective);
}
