package pl.mgk.hubertrybarczyk.createyourself.service;

import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;

import java.util.Set;

public interface TodoService extends CrudService<Todo, Long> {
    Set<Todo> findByObjective(Objective objective);
}
