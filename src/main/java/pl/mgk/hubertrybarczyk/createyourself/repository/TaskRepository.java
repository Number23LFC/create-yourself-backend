package pl.mgk.hubertrybarczyk.createyourself.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mgk.hubertrybarczyk.createyourself.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findByName(String name);
}
