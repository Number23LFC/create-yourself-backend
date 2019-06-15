package pl.mgk.hubertrybarczyk.createyourself.service;

import java.util.Set;
import pl.mgk.hubertrybarczyk.createyourself.model.Task;

public interface TaskService extends CrudService<Task, Long> {
    Task findByName(String name);
    Set<Task> findByCategory(String name);
}
