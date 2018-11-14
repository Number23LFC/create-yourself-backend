package pl.mgk.hubertrybarczyk.createyourself.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;

public interface ObjectiveRepository extends CrudRepository<Objective, Long> {
}
